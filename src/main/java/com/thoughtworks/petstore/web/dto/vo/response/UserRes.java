package com.thoughtworks.petstore.web.dto.vo.response;

import com.thoughtworks.petstore.web.dto.enums.Gender;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRes {
    private String id;
    private String name;
    private Gender gender;
    private String email;
    private String phone;
}
