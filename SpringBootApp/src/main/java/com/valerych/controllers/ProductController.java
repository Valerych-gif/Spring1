package com.valerych.controllers;

import com.valerych.entites.Product;
import com.valerych.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/edit/{id}")
    String productEditForm(Model model, @PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/edit")
    String productEdit(@RequestParam("id") Long id, @RequestParam("title") String title, @RequestParam("cost") int cost){
        productService.updateProduct(id, title, cost);
        return "redirect:/";
    }

    @RequestMapping("/add")
    String productAddForm(){
        return "add";
    }

    @PostMapping("/add")
    String productAdd(@RequestParam("title") String title, @RequestParam("cost") int cost){
        productService.addProduct(new Product(title, cost));
        return "redirect:/";
    }
}
