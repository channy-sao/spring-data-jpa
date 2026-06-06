package org.example.spring_data_jpa.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    private String name;
    private Long categoryId;
    private BigDecimal price;
    private String description;
}
