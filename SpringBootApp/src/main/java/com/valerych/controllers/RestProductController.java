package com.valerych.controllers;

import com.valerych.entites.Product;
import com.valerych.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestProductController {

    @Autowired
    private ProductService productService;

    public void setProductRepository(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    List<Product> productsPage() {
        List<Product> products = productService.getAllProduct();
        return products;
    }

    @GetMapping("/{id}")
    Product productPage(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/")
    int productAddOrUpdate(@RequestBody Product product){
        productService.addProduct(product);
        return HttpStatus.OK.value();
    }
}
