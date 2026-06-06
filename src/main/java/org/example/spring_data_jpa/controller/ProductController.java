package org.example.spring_data_jpa.controller;

import lombok.RequiredArgsConstructor;
import org.example.spring_data_jpa.dto.request.ProductRequest;
import org.example.spring_data_jpa.dto.response.ProductResponse;
import org.example.spring_data_jpa.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> save(@RequestBody ProductRequest product) {
        return ResponseEntity.ok(productService.save(product));
    }
}
