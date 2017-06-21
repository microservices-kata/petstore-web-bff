package com.thoughtworks.petstore.web.dto.response;

import com.thoughtworks.petstore.web.dto.enums.Gender;
import org.springframework.http.HttpStatus;

public class UserRes extends GeneralRes {
    private String id;
    private String name;
    private Gender gender;
    private String email;
    private String phone;

    public UserRes(HttpStatus status, String message) {
        super(status, message);
    }

    public UserRes(String id, String name, Gender gender, String email, String phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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
