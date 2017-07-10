package com.thoughtworks.petstore.web.dto.vo.response;

import com.thoughtworks.petstore.web.dto.enums.OrderStatus;
import java.util.Date;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDigestRes {
    private String id;
    private OrderStatus orderStatus;
    private Date orderTime;
}
