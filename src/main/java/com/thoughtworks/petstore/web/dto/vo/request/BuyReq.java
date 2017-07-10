package com.thoughtworks.petstore.web.dto.vo.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyReq {
    private String petId;
    private Integer amount;
}
