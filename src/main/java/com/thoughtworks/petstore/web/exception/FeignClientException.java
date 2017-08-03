package com.thoughtworks.petstore.web.exception;


import com.netflix.hystrix.exception.HystrixBadRequestException;

public class FeignClientException extends HystrixBadRequestException {

    private final Integer code;

    public FeignClientException(int code, String message) {
        super(message);
        this.code = code;
    }

    public FeignClientException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
