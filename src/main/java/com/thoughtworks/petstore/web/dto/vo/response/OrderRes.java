package com.thoughtworks.petstore.web.dto.vo.response;

import com.thoughtworks.petstore.web.dto.enums.OrderStatus;

import java.util.Date;

public class OrderRes extends OrderDigestRes {
    private PetRes pet;
    private UserRes user;

    public OrderRes(String id, OrderStatus orderStatus, Date orderTime, PetRes pet, UserRes user) {
        super(id, orderStatus, orderTime);
        this.pet = pet;
        this.user = user;
    }

    public PetRes getPet() {
        return pet;
    }

    public void setPet(PetRes pet) {
        this.pet = pet;
    }

    public UserRes getUser() {
        return user;
    }

    public void setUser(UserRes user) {
        this.user = user;
    }
}
