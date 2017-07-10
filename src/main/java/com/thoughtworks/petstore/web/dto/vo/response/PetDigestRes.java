package com.thoughtworks.petstore.web.dto.vo.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetDigestRes {
    private String id;
    private String shopName;
    private String shopAddr;
    private Double price;
    private String thumbnailUrl;
}
