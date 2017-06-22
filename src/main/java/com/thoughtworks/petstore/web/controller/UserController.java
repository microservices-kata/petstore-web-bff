package com.thoughtworks.petstore.web.controller;

import com.thoughtworks.petstore.web.dto.enums.Gender;
import com.thoughtworks.petstore.web.dto.enums.ResStatus;
import com.thoughtworks.petstore.web.dto.request.LoginReq;
import com.thoughtworks.petstore.web.dto.request.UserReq;
import com.thoughtworks.petstore.web.dto.response.UserRes;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @ApiOperation(value = "Register user")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UserRes> register(@RequestBody UserReq userReq) {
        if (userReq.getEmail().equals("abc@tw.com")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new UserRes(ResStatus.BAD_REQUEST, "Email already occupied"));
        } else if (userReq.getPhone().equals("123456789")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new UserRes(ResStatus.BAD_REQUEST, "Phone number already occupied"));
        } else if (userReq.getPhone().equals("123456789")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new UserRes(ResStatus.BAD_REQUEST, "User already exist"));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new UserRes("0001",
                            userReq.getName(),
                            userReq.getGender(),
                            userReq.getEmail(),
                            userReq.getPhone()));
        }
    }

    @ApiOperation(value = "User login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<UserRes> login(@RequestBody LoginReq registerReq) {
        if (registerReq.getName().equals("fan") && registerReq.getPassword().equals("fan")) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new UserRes("0001", "Fan", Gender.Male, "abc@tw.com", "123456789"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new UserRes(ResStatus.BAD_REQUEST, "Incorrect username or password"));
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
