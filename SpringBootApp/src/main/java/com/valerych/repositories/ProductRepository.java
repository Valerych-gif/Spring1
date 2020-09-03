package com.valerych.repositories;

import com.valerych.entites.Product;
import com.valerych.entites.Product;
import org.hibernate.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByCostBetween(int mincost, int maxcost);
    List<Product> findProductByCostGreaterThan(int mincost);

    @Override
    Page<Product> findAll(Pageable pageable);

    @Modifying
    @Query("UPDATE Product p SET p.title = ?2, p.cost = ?3 WHERE p.id = ?1")
    void updateById(long id, String title, int cost);
}
