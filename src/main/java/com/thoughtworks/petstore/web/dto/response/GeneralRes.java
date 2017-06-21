package com.thoughtworks.petstore.web.dto.response;

import org.springframework.http.HttpStatus;

public class GeneralRes {
    private HttpStatus status;
    private String message;

    public GeneralRes(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public GeneralRes() {
        this.status = HttpStatus.OK;
        this.message = "";
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
