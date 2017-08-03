package com.thoughtworks.petstore.web.controller;


import com.thoughtworks.petstore.web.dto.vo.ExceptionVo;
import com.thoughtworks.petstore.web.exception.FeignClientException;
import com.thoughtworks.petstore.web.exception.NoPermissionException;
import com.thoughtworks.petstore.web.exception.NoResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ErrorController {

    @ExceptionHandler(FeignClientException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionVo badRequestHandler(FeignClientException exception) {
        return new ExceptionVo(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler(NoPermissionException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ExceptionVo noPermissionHandler(NoPermissionException exception) {
        return new ExceptionVo(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler(NoResponseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionVo noResponseHandler(NoResponseException exception) {
        return new ExceptionVo(exception.getCode(), exception.getMessage());
    }
}
