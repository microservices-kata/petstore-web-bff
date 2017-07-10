package com.thoughtworks.petstore.web.dto.vo.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefundReq {
    private String orderId;
}
