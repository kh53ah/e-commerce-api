package com.khaled_GmbH.e.commerce.api.repositories;

import com.khaled_GmbH.e.commerce.api.entities.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository <Order, Integer> {
    List<Order> findByUserId(Long userId);
}
