package com.khaled_GmbH.e.commerce.api.repositories;

import com.khaled_GmbH.e.commerce.api.entities.OrderItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemRepository extends CrudRepository <OrderItem, Integer> {
    List<OrderItem> findByOrderId(Integer orderId);
}
