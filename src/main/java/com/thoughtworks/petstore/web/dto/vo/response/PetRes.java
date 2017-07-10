package com.thoughtworks.petstore.web.dto.vo.response;

import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
public class PetRes extends PetDigestRes {
    private String shopDescription;
    private String shopPhoneNum;
    private String shopImageUrl;
    private Integer inventoryAmount;
    private String description;
    private List<String> imageUrls;

    public PetRes(String id, String shopName, String shopAddr, String shopDescription,
                  String shopPhoneNum, String shopImageUrl, Double price, String thumbnailUrl,
                  Integer inventoryAmount, String description, List<String> imageUrls) {
        super(id, shopName, shopAddr, price, thumbnailUrl);
        this.shopDescription = shopDescription;
        this.shopPhoneNum = shopPhoneNum;
        this.shopImageUrl = shopImageUrl;
        this.inventoryAmount = inventoryAmount;
        this.description = description;
        this.imageUrls = imageUrls;
    }
}
