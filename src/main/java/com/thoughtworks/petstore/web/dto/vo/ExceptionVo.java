package com.thoughtworks.petstore.web.dto.vo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionVo {
    private Integer code;
    private String message;
}
