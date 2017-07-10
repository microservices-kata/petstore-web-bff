package com.thoughtworks.petstore.web.service.account.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPo {
    private String name;
    private String password;
    private String gender;
    private String email;
    private String phone;
}
