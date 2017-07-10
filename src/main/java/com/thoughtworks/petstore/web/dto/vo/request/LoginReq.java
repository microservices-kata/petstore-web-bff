package com.thoughtworks.petstore.web.dto.vo.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginReq {
    private String name;
    private String password;
}
