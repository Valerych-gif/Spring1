package com.valerych.controllers;

import com.valerych.entites.Product;
import com.valerych.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    public void setProductRepository(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    String productPage(Model model, @PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @GetMapping("/delete/{id}")
    String productDelete(Model model, @PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        productService.deleteProduct(product);
        return "redirect:/";
    }
}
