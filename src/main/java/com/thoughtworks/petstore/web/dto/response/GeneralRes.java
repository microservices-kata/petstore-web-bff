package com.thoughtworks.petstore.web.dto.response;

import com.thoughtworks.petstore.web.dto.enums.ResStatus;

public class GeneralRes {
    private ResStatus status;
    private String message;

    public GeneralRes(ResStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public GeneralRes() {
        this.status = ResStatus.OK;
        this.message = "";
    }

    public ResStatus getStatus() {
        return status;
    }

    public void setStatus(ResStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
