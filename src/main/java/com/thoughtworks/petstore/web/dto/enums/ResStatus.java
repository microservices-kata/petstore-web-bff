package com.thoughtworks.petstore.web.dto.enums;

public enum ResStatus {
    OK(200),
    UNAUTHORIZED(401),
    BAD_REQUEST(400),
    NOT_FOUND(404),
    SERVER_ERROR(500);

    private Integer code;

    ResStatus(Integer code) {
        this.code = code;
    }
}
