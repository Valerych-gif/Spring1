package com.geekbrains.controllers;

import com.geekbrains.entites.Product;
import com.geekbrains.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping ("/home")
public class HomeController {

    private ProductService productService;

    @Autowired
    public void setProductRepository(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping ("/")
    public String home(Model model){
        return showHomePage(model);
    }

    @RequestMapping(path = "/product/{sid}")
    public String showProductById(Model model, @PathVariable("sid") int id) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping("/addproduct")
    public String showAddProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "addProduct-form";
    }

    @RequestMapping("/processForm")
    public String addProduct(Model model, Product product) {
        productService.addProduct(product);
        return showHomePage(model);
    }

    private String showHomePage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "index";
    }
}
