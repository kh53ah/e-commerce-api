package com.khaled_GmbH.e.commerce.api.mappers;

import com.khaled_GmbH.e.commerce.api.controllers.UpdateUserRequest;
import com.khaled_GmbH.e.commerce.api.dtos.ProductDto;
import com.khaled_GmbH.e.commerce.api.entities.Product;
import com.khaled_GmbH.e.commerce.api.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toDto(Product product);
    Product toEntity(ProductDto request);
    void update(ProductDto request, @MappingTarget Product product);
}
