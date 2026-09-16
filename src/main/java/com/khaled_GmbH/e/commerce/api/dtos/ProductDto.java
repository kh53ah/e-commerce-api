package com.khaled_GmbH.e.commerce.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
@AllArgsConstructor
@Getter
public class ProductDto {
    private String name;
    private String description;
    private BigDecimal price;
    private Byte categoryId;
}
