package com.valerych.controllers;

import com.valerych.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/admindashboard")
public class AdminController {

    @Autowired
    private ProductService productService;

    public void setProductRepository(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    String setUp() {
        return "admindashboard";
    }

    @GetMapping("/setupstore")
    String setUpStore() {
        productService.setUpStore();
        return "redirect:/";
    }

}
