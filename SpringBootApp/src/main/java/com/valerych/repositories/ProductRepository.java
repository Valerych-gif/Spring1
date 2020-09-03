package com.valerych.repositories;

import com.valerych.entites.Product;
import com.valerych.entites.Product;
import org.hibernate.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByCostBetween(int mincost, int maxcost);
    List<Product> findProductByCostGreaterThan(int mincost);

    @Override
    Page<Product> findAll(Pageable pageable);
}
