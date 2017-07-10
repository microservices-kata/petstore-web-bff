package com.thoughtworks.petstore.web.service.account.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWithIdPo {
    private Long userId;
    private String name;
    private String gender;
    private String email;
    private String phone;
}
