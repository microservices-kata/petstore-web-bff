package com.thoughtworks.petstore.web.service.account;

import com.thoughtworks.petstore.web.service.account.dto.UserPo;
import com.thoughtworks.petstore.web.service.account.dto.UserWithIdPo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "account-service", fallback = UserServiceFeignClientFallback.class)
public interface UserServiceFeignClient {

    @RequestMapping(value = "/api/users/{userId}", method = RequestMethod.GET)
    UserWithIdPo getUser(@PathVariable("userId") Long userId);

    @RequestMapping(value = "/api/users", method = RequestMethod.PUT)
    UserWithIdPo updateUser(@RequestBody UserPo userPo);

    @RequestMapping(value = "/api/users", method = RequestMethod.POST)
    UserWithIdPo createUser(@RequestBody UserPo userPo);

    @RequestMapping(value = "/api/users/authentication", method = RequestMethod.GET)
    UserWithIdPo matchUserCredential(@RequestParam("name") String name, @RequestParam("pass") String pass);

}
