package com.thoughtworks.petstore.web.dto.response;

import java.util.List;

public class PetRes extends PetDigestRes {
    private String shopDescription;
    private String shopPhoneNum;
    private String shopImageUrl;
    private Integer inventoryAmount;
    private String description;
    private List<String> imageUrls;

    public PetRes(String id, String shopName, String shopAddr, String shopDescription, String shopPhoneNum, String shopImageUrl,
            Double price, String thumbnailUrl, Integer inventoryAmount, String description, List<String> imageUrls) {
        super(id, shopName, shopAddr, price, thumbnailUrl);
        this.shopDescription = shopDescription;
        this.shopPhoneNum = shopPhoneNum;
        this.shopImageUrl = shopImageUrl;
        this.inventoryAmount = inventoryAmount;
        this.description = description;
        this.imageUrls = imageUrls;
    }

    public String getShopDescription() {
        return shopDescription;
    }

    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription;
    }

    public String getShopPhoneNum() {
        return shopPhoneNum;
    }

    public void setShopPhoneNum(String shopPhoneNum) {
        this.shopPhoneNum = shopPhoneNum;
    }

    public String getShopImageUrl() {
        return shopImageUrl;
    }

    public void setShopImageUrl(String shopImageUrl) {
        this.shopImageUrl = shopImageUrl;
    }

    public Integer getInventoryAmount() {
        return inventoryAmount;
    }

    public void setInventoryAmount(Integer inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
