package org.example.spring_data_jpa.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.spring_data_jpa.dto.request.ProductRequest;
import org.example.spring_data_jpa.dto.response.BaseBodyResponse;
import org.example.spring_data_jpa.dto.response.ProductResponse;
import org.example.spring_data_jpa.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
@Tag(name = "Product Controller", description = "For Product Management API")
public class ProductController {

    private final ProductService productService;

    @Operation(
            summary = "Get Product",
            description = "Get product by id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<BaseBodyResponse<ProductResponse>> findById( @Parameter(description = "Product ID") @PathVariable Long id) {
        return BaseBodyResponse.success(productService.findById(id), "Success");
    }

    @PostMapping
    public ResponseEntity<BaseBodyResponse<ProductResponse>> save(@RequestBody ProductRequest product) {
        return BaseBodyResponse.success(productService.save(product), "Success");
    }

    @GetMapping("/filter")
    public ResponseEntity<BaseBodyResponse<List<ProductResponse>>> filter(@RequestParam(defaultValue = "1") int page,
                                                                          @RequestParam(defaultValue ="10") int size,
                                                                          @RequestParam(required = false) String filter) {
        return BaseBodyResponse.pageSuccess(productService.filter(page, size, filter), "Success");
    }
}
