package com.geekbrains.service;

import com.geekbrains.entites.Product;
import com.geekbrains.repositories.ProductRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductService() {

    }

    public Product getProductById(int id) {
        return productRepository.findOneById(id);
    }

    public List<Product> getAllProducts(){
//        productRepository.pullProductsFromDB();
        return productRepository.getProducts();
    }

    public void addProduct(Product product){
        productRepository.addProduct(product);
    }

    public void deleteProductById(int id) {
        productRepository.deleteOneById(id);
    }
}