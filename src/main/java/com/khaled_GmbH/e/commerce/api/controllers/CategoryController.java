package com.khaled_GmbH.e.commerce.api.controllers;

import com.khaled_GmbH.e.commerce.api.dtos.CategoryDto;
import com.khaled_GmbH.e.commerce.api.mappers.CategoryMapper;
import com.khaled_GmbH.e.commerce.api.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    @GetMapping
    public Iterable<CategoryDto> getAllCategories() {

        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDto)
                .toList();
    }

    @PostMapping
    public ResponseEntity <CategoryDto> createCategory(
            @RequestBody CategoryDto request) {
        var category = categoryMapper.toEntity(request);
        categoryRepository.save(category);

        return ResponseEntity.ok(request);
    }
}
