package com.thoughtworks.petstore.web.service.account.dto;


import com.thoughtworks.petstore.web.dto.enums.Gender;

public class UserWithIdPo extends UserPo {

    private Long userId;

    public UserWithIdPo() {
    }

    public UserWithIdPo(String name, String password, Gender gender,
                        String email, String phone, Long userId) {
        super(name, password, gender, email, phone);
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
