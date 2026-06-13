package org.example.spring_data_jpa.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.spring_data_jpa.dto.request.CategoryRequest;
import org.example.spring_data_jpa.dto.response.CategoryResponse;
import org.example.spring_data_jpa.entity.Category;
import org.example.spring_data_jpa.exception.NotFoundException;
import org.example.spring_data_jpa.mapper.CategoryMapper;
import org.example.spring_data_jpa.repository.CategoryRepository;
import org.example.spring_data_jpa.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public CategoryResponse save(CategoryRequest categoryRequest) {
        log.info("Saving category: {}", categoryRequest);
        Category category = Category.builder()
                .name(categoryRequest.getName())
                .description(categoryRequest.getDescription())
                .build();
        Category save = categoryRepository.save(category);

        return CategoryMapper.toCategoryResponse(save);
    }

    @Override
    public CategoryResponse update(CategoryRequest categoryRequest, Long id) {
        log.info("Updating category id {} : {}",id, categoryRequest);
        Category category = getById(id);

        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());
        Category saved= categoryRepository.save(category);
        return CategoryMapper.toCategoryResponse(saved);
    }

    @Override
    public CategoryResponse findById(Long id) {
        log.info("Finding category by id : {}", id);
        Category category = getById(id);
        return CategoryMapper.toCategoryResponse(category);
    }

    private Category getById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Category not found with id %s".formatted(id))
        );
    }

    @Override
    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll().stream().map(
                CategoryMapper::toCategoryResponse
        ).toList();
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
