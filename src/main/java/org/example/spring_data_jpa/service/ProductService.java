package org.example.spring_data_jpa.service;

import org.example.spring_data_jpa.dto.request.ProductRequest;
import org.example.spring_data_jpa.dto.response.ProductResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    ProductResponse findById(Long id);
    ProductResponse findByName(String name);
    List<ProductResponse> findByCategory(Long categoryId);
    ProductResponse save(ProductRequest product);
    ProductResponse updateProduct(ProductRequest product, Long id);
    void deleteById(Long id);

    Page<ProductResponse> filter(int page, int size, String filter);
}
