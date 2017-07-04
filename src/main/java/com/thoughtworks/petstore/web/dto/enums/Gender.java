package com.thoughtworks.petstore.web.dto.enums;

public enum Gender {
    Male("Male"),
    Female("Female"),
    Unknown("Unknown");

    String gender;
    Gender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}
