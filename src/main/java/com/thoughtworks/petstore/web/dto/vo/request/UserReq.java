package com.thoughtworks.petstore.web.dto.vo.request;

import com.thoughtworks.petstore.web.dto.enums.Gender;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReq {
    private String name;
    private String password;
    private Gender gender;
    private String email;
    private String phone;
}
