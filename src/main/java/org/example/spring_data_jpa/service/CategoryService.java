package org.example.spring_data_jpa.service;

import org.example.spring_data_jpa.dto.request.CategoryRequest;
import org.example.spring_data_jpa.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse save(CategoryRequest categoryRequest);
    CategoryResponse update(CategoryRequest categoryRequest, Long id);
    CategoryResponse findById(Long id);
    List<CategoryResponse> findAll();
    void deleteById(Long id);
}
