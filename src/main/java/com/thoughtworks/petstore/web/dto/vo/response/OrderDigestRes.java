package com.thoughtworks.petstore.web.dto.vo.response;

import com.thoughtworks.petstore.web.dto.enums.OrderStatus;

import java.util.Date;

public class OrderDigestRes extends GeneralRes {
    private String id;
    private OrderStatus orderStatus;
    private Date orderTime;

    public OrderDigestRes(String id, OrderStatus orderStatus, Date orderTime) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.orderTime = orderTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
