package com.thoughtworks.petstore.web.controller;

import com.thoughtworks.petstore.web.dto.assembler.UserAssembler;
import com.thoughtworks.petstore.web.dto.enums.Gender;
import com.thoughtworks.petstore.web.dto.enums.ResStatus;
import com.thoughtworks.petstore.web.dto.vo.request.LoginReq;
import com.thoughtworks.petstore.web.dto.vo.request.UserReq;
import com.thoughtworks.petstore.web.dto.vo.response.UserRes;
import com.thoughtworks.petstore.web.exception.FeignClientException;
import com.thoughtworks.petstore.web.service.account.UserServiceFeignClient;
import com.thoughtworks.petstore.web.service.account.dto.UserWithIdPo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceFeignClient userServiceFeignClient;
    @Autowired
    private UserAssembler userAssembler;

    @ApiOperation(value = "Register user")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UserRes> register(@RequestBody UserReq userReq) {
        try {
            UserWithIdPo userWithIdPo = userServiceFeignClient.createUser(userAssembler.userReq2UserPo(userReq));
            if (userWithIdPo == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                        new UserRes(ResStatus.SERVER_ERROR, "Service no response"));
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(
                        userAssembler.userWithIdPo2UserRes(userWithIdPo));
            }
        } catch (FeignClientException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new UserRes(ResStatus.BAD_REQUEST, e.getMessage()));
        }
    }

    @ApiOperation(value = "User login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<UserRes> login(@RequestBody LoginReq loginReq) {
        UserWithIdPo userWithIdPo =
                userServiceFeignClient.matchUserCredential(loginReq.getName(), loginReq.getPassword());
        if (userWithIdPo == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new UserRes(ResStatus.SERVER_ERROR, "Service no response"));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    userAssembler.userWithIdPo2UserRes(userWithIdPo));
        }
    }

    @ApiOperation(value = "Get user info")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseEntity<UserRes> getInfo(@RequestHeader(value = "User-Id") String userId) {
        if (userId.equals("0001")) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new UserRes("0001", "Fan", Gender.Male, "abc@tw.com", "123456789"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    new UserRes(ResStatus.UNAUTHORIZED, "No permission to user " + userId));
        }
    }

    @ApiOperation(value = "Update user info")
    @RequestMapping(value = "/info", method = RequestMethod.PUT)
    public ResponseEntity<UserRes> updateInfo(@RequestHeader(value = "User-Id") String userId,
                                              @RequestBody UserReq userReq) {
        if (userId.equals("0001")) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new UserRes("0001",
                            userReq.getName(),
                            userReq.getGender(),
                            userReq.getEmail(),
                            userReq.getPhone()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    new UserRes(ResStatus.UNAUTHORIZED, "No permission to user " + userId));
        }
    }

}
