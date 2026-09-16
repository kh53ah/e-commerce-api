package com.khaled_GmbH.e.commerce.api.mappers;

import com.khaled_GmbH.e.commerce.api.dtos.CategoryDto;
import com.khaled_GmbH.e.commerce.api.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto request);
}
