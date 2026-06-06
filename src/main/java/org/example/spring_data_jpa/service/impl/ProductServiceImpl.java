package org.example.spring_data_jpa.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.spring_data_jpa.dto.request.ProductRequest;
import org.example.spring_data_jpa.dto.response.ProductResponse;
import org.example.spring_data_jpa.entity.Category;
import org.example.spring_data_jpa.entity.Product;
import org.example.spring_data_jpa.exception.NotFoundException;
import org.example.spring_data_jpa.mapper.ProductMapper;
import org.example.spring_data_jpa.repository.CategoryRepository;
import org.example.spring_data_jpa.repository.ProductRepository;
import org.example.spring_data_jpa.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    @Override
    public ProductResponse findById(Long id) {
        Product product = getById(id);
        return ProductMapper.toProductResponse(product);
    }

    private Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Product not found with id: " + id)
        );
    }

    @Override
    public ProductResponse findByName(String name) {
        Product product = productRepository.findByNameIgnoreCase(name).orElseThrow(
                () -> new NotFoundException("Product not found with name :"+ name)
        );
        return ProductMapper.toProductResponse(product);
    }

    @Override
    public List<ProductResponse> findByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId).stream().map(ProductMapper::toProductResponse).toList();

    }

    @Override
    public ProductResponse save(ProductRequest productRequest) {
        Optional<Category> categoryOptional = categoryRepository.findById(productRequest.getCategoryId());
        if (categoryOptional.isEmpty()) {
            throw new RuntimeException("Category not found");
        }
        Category category = categoryOptional.get();
        Product product = Product.builder()
                .name(productRequest.getName())
                .category(category)
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .build();
        Product productSaved =productRepository.save(product);
        return ProductMapper.toProductResponse(productSaved);
    }

    @Override
    public ProductResponse updateProduct(ProductRequest productRequest, Long id) {
        Product product = getById(id);

        Optional<Category> categoryOptional = categoryRepository.findById(productRequest.getCategoryId());
        if (categoryOptional.isEmpty()) {
            throw new NotFoundException("Category not found");
        }

        product.setName(productRequest.getName());
        product.setCategory(categoryOptional.get());
        product.setPrice(product.getPrice());
        product.setDescription(productRequest.getDescription());

        Product updated = productRepository.save(product);
        return ProductMapper.toProductResponse(updated);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
