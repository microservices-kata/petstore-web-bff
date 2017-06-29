package com.thoughtworks.petstore.web.dto.vo.response;

public class PetDigestRes extends GeneralRes {
    private String id;
    private String shopName;
    private String shopAddr;
    private Double price;
    private String thumbnailUrl;

    public PetDigestRes(String id, String shopName, String shopAddr, Double price, String thumbnailUrl) {
        this.id = id;
        this.shopName = shopName;
        this.shopAddr = shopAddr;
        this.price = price;
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddr() {
        return shopAddr;
    }

    public void setShopAddr(String shopAddr) {
        this.shopAddr = shopAddr;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
