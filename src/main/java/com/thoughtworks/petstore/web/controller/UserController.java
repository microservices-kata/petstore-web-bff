package com.thoughtworks.petstore.web.controller;

import com.thoughtworks.petstore.web.dto.assembler.UserAssembler;
import com.thoughtworks.petstore.web.dto.vo.request.LoginReq;
import com.thoughtworks.petstore.web.dto.vo.request.UserReq;
import com.thoughtworks.petstore.web.dto.vo.response.UserRes;
import com.thoughtworks.petstore.web.exception.NoPermissionException;
import com.thoughtworks.petstore.web.service.account.UserServiceFeignClient;
import com.thoughtworks.petstore.web.service.account.dto.UserWithIdPo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController extends ErrorController {

    @Autowired
    private UserServiceFeignClient userServiceFeignClient;
    @Autowired
    private UserAssembler userAssembler;

    @ApiOperation(value = "Register user")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UserRes register(@RequestBody UserReq userReq) {
        UserWithIdPo userWithIdPo = userServiceFeignClient.createUser(userAssembler.userReq2UserPo(userReq));
        return userAssembler.userWithIdPo2UserRes(userWithIdPo);
    }

    @ApiOperation(value = "User login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserRes login(@RequestBody LoginReq loginReq) {
        UserWithIdPo userWithIdPo =
                userServiceFeignClient.matchUserCredential(loginReq.getName(), loginReq.getPassword());
        return userAssembler.userWithIdPo2UserRes(userWithIdPo);
    }

    @ApiOperation(value = "Get user info")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public UserRes getInfo(@RequestHeader(value = "User-Id") String userId) {
        UserWithIdPo userWithIdPo = userServiceFeignClient.getUser(Long.valueOf(userId));
        return userAssembler.userWithIdPo2UserRes(userWithIdPo);
    }

    @ApiOperation(value = "Update user info")
    @RequestMapping(value = "/info", method = RequestMethod.PUT)
    public UserRes updateInfo(@RequestHeader(value = "User-Id") String userId,
                                              @RequestBody UserReq userReq) {
        UserWithIdPo userWithIdPo = userServiceFeignClient.updateUser(userAssembler.userReq2UserPo(userReq));
        if (Long.valueOf(userId).equals(userWithIdPo.getUserId())) {
            return userAssembler.userWithIdPo2UserRes(userWithIdPo);
        } else {
            throw new NoPermissionException(HttpStatus.UNAUTHORIZED.value(), "No permission to user " + userId);
        }
    }

}
