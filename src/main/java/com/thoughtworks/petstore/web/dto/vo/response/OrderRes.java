package com.thoughtworks.petstore.web.dto.vo.response;

import com.thoughtworks.petstore.web.dto.enums.OrderStatus;
import java.util.Date;
import lombok.*;

@Data
@NoArgsConstructor
public class OrderRes extends OrderDigestRes {
    private PetRes pet;
    private UserRes user;

    public OrderRes(String id, OrderStatus orderStatus, Date orderTime, PetRes pet, UserRes user) {
        super(id, orderStatus, orderTime);
        this.pet = pet;
        this.user = user;
    }
}
