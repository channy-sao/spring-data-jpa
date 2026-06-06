package org.example.spring_data_jpa.mapper;

import org.example.spring_data_jpa.dto.response.ProductResponse;
import org.example.spring_data_jpa.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public static ProductResponse toProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        productResponse.setCategory(CategoryMapper.toCategoryResponse(product.getCategory()));
        return productResponse;
    }
}
