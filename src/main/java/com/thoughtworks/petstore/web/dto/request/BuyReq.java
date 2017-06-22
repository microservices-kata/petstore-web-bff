package com.thoughtworks.petstore.web.dto.request;

public class BuyReq {
    private String petId;
    private Integer amount;

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
