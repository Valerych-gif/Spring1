package com.valerych.controllers;

import com.valerych.entites.Product;
import com.valerych.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    public void setProductRepository(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    String homePage(Model model) {

        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/filterlist")
    String filterPage(Model model,
                      @RequestParam(value = "mincost", required = false, defaultValue = "0") String mincost,
                      @RequestParam(value = "maxcost", required = false, defaultValue = "0") String maxcost) {
        int minc = Integer.parseInt(mincost);
        int maxc = Integer.parseInt(maxcost);
        System.out.println("mincost: " + mincost + "\n\rmaxcost: " + maxcost);
        List<Product> products = productService.getProductsByCost(minc, maxc);
        model.addAttribute("products", products);
        return "index";
    }

}
