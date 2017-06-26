package com.thoughtworks.petstore.web.service.account;

import com.thoughtworks.petstore.web.service.account.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "account-service", fallback = UserServiceFeignClientFallback.class)
public interface UserServiceFeignClient {
    @RequestMapping(value = "/api/users/{userId}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    User getUser(@PathVariable("userId") Long userId);

    @RequestMapping(value = "/api/users", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    User updateUser(@RequestBody User user);

    @RequestMapping(value = "/api/users", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    User createUser(@RequestBody User user);
}
