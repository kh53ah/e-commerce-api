package com.khaled_GmbH.e.commerce.api.repositories;

import com.khaled_GmbH.e.commerce.api.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByName(String name);
}
