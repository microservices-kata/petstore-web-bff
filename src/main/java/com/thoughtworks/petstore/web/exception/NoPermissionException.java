package com.thoughtworks.petstore.web.exception;


public class NoPermissionException extends RuntimeException {

    private final Integer code;

    public NoPermissionException(int code, String message) {
        super(message);
        this.code = code;
    }

    public NoPermissionException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
