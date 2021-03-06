package com.geekbrains.geekmarket.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="user_id")
    private Long user_id;
}
