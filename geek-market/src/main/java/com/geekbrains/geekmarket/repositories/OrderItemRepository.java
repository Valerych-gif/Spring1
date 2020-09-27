package com.geekbrains.geekmarket.repositories;

import com.geekbrains.geekmarket.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
