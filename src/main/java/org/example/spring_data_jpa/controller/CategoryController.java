package org.example.spring_data_jpa.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.spring_data_jpa.dto.request.CategoryRequest;
import org.example.spring_data_jpa.dto.response.BaseBodyResponse;
import org.example.spring_data_jpa.dto.response.CategoryResponse;
import org.example.spring_data_jpa.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@Tag(name = "Category Controller")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<BaseBodyResponse<List<CategoryResponse>>> findAll() {
        return BaseBodyResponse.success(categoryService.findAll(), "Success");
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseBodyResponse<CategoryResponse>> findById(@PathVariable Long id) {
        return BaseBodyResponse.success(categoryService.findById(id),  "Success");
    }

    @PostMapping
    public ResponseEntity<BaseBodyResponse<CategoryResponse>> save(@RequestBody CategoryRequest categoryRequest) {
        return BaseBodyResponse.success(categoryService.save(categoryRequest), "Success");
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseBodyResponse<CategoryResponse>> update(@RequestBody CategoryRequest categoryRequest, @PathVariable Long id) {
        return BaseBodyResponse.success(categoryService.update(categoryRequest, id), "Success");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseBodyResponse<Void>> deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
        return BaseBodyResponse.success("Success");
    }
}
