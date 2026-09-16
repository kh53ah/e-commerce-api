package com.khaled_GmbH.e.commerce.api.repositories;

import com.khaled_GmbH.e.commerce.api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);
    List<Product> findByPrice(BigDecimal price);
    List<Product> findByCategoryId(Byte categoryId);
}
