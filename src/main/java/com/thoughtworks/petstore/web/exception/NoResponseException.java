package com.thoughtworks.petstore.web.exception;


public class NoResponseException extends RuntimeException {

    private final Integer code;

    public NoResponseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public NoResponseException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
