package com.geekbrains.entites;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_tbl")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_fld")
    private String name;

    public Customer() {
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "customerproduct_tbl", // название таблицы
            joinColumns = @JoinColumn(name = "customer_id"),  // то что связываем
            inverseJoinColumns = @JoinColumn(name = "product_id") // то на что связываем
    )
    private List<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
