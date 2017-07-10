package com.thoughtworks.petstore.web.dto.vo.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategorieRes {
    private String id;
    private String name;
    private String description;
    private String imageUrl;
}
