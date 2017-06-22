package com.thoughtworks.petstore.web.controller;

import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/app")
public class AppController {

    @Value("${spring.profiles}")
    String env;

    @ApiOperation(value = "Show runtime information")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Map getInfo() {
        return ImmutableMap.of("environment", env);
    }

}
