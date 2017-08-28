package com.thoughtworks.petstore.web.dto.enums;

public enum Gender {
    Male("Male"),
    Female("Female"),
    Unknown("Unknown");

    String gender;
    Gender(String gender) {
        this.gender = gender;
    }

    public static Gender fromString(String gender) {
        try {
            return Gender.valueOf(gender);
        } catch (IllegalArgumentException e) {
            return Gender.valueOf("Unknown");
        }
    }

    @Override
    public String toString() {
        return gender;
    }
}
