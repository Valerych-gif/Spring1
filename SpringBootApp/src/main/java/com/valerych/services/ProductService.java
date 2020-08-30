package com.valerych.services;

import com.valerych.entites.Product;
import com.valerych.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Product getProductById(Long id) {
        return productRepository.getOne(id);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Page<Product> getAllProductsByPage(int start, int productOnPage){
        Pageable pageable = PageRequest.of(start, productOnPage);
        return productRepository.findAll(pageable);
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public void setUpStore(){
        productRepository.deleteAll();
        for (int i = 0; i < 20; i++) {
            Product product = new Product("Product " + i, i*10);
            productRepository.save(product);
        }
    }

    public List<Product> getProductsByCost(int mincost, int maxcost) {
        if (mincost<0){
            maxcost = 0;
        }

        List<Product> products;
        if (maxcost>0){
            products = productRepository.findProductByCostBetween(mincost, maxcost);
        } else {
            products = productRepository.findProductByCostGreaterThan(mincost);
        }
        return products;
    }
}