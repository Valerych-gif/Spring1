package com.geekbrains.repositories;

import com.geekbrains.entites.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("Cheese", 100));
        products.add(new Product("Milk", 20));
        products.add(new Product("Bread", 15));
        products.add(new Product("Potatoes", 12));
    }

    public Product findOneById(int id) {
        for (Product product : products) {
            if (product.getId()==id)
                return product;
        }
        return null;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(new Product(product.getTitle(), product.getCost()));
    }
}
