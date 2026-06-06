package org.example.spring_data_jpa.dto.request;

import lombok.Data;

@Data
public class CategoryRequest {
    private String name;
    private String description;
}
