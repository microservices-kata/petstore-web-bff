package com.thoughtworks.petstore.web.service.account.dto;

import com.thoughtworks.petstore.web.dto.enums.Gender;

public class UserPo {
    private String name;
    private String password;
    private String gender;
    private String email;
    private String phone;

    public UserPo(String name, String password,
                  Gender gender, String email, String phone) {
        this.name = name;
        this.password = password;
        this.gender = gender.toString();
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
