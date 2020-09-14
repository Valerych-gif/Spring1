package com.geekbrains.geekmarket.repositories;

import com.geekbrains.geekmarket.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
