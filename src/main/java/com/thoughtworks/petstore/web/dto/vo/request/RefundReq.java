package com.thoughtworks.petstore.web.dto.vo.request;

public class RefundReq {
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
