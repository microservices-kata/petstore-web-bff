package com.thoughtworks.petstore.web.service.account.dto;


public class UserWithIdPo {

    private Long userId;
    private String name;
    private String gender;
    private String email;
    private String phone;

    public UserWithIdPo() {
    }

    public UserWithIdPo(Long userId, String name, String gender, String email, String phone) {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
