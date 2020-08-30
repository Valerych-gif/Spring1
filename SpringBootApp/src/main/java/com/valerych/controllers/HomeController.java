package com.valerych.controllers;

import com.valerych.entites.Product;
import com.valerych.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    class PageLink{
        private int pageNumber;
        private String activeClass;

        public PageLink(int pageNumber, String activeClass) {
            this.pageNumber = pageNumber;
            this.activeClass = activeClass;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public String getActiveClass() {
            return activeClass;
        }
    }
    private final static int PRODUCT_ON_PAGE = 5;

    @Autowired
    private ProductService productService;

    public void setProductRepository(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    String homePage(Model model, @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        int productCount = productService.getAllProduct().size();
        int pagesCount = productCount%PRODUCT_ON_PAGE==0?productCount/PRODUCT_ON_PAGE:productCount/PRODUCT_ON_PAGE+1;
        List<PageLink> pageLinks = new ArrayList<>();
        for (int i = 0; i < pagesCount; i++) {
            if (i==page) {
                pageLinks.add(new PageLink(i, "active"));
            } else{
                pageLinks.add(new PageLink(i, ""));
            }
        }
        Page<Product> products = productService.getAllProductsByPage(page, PRODUCT_ON_PAGE);
        model.addAttribute("products", products);
        model.addAttribute("pagelinks", pageLinks);
        return "index";
    }

    @GetMapping("/filterlist")
    String filterPage(Model model,
                      @RequestParam(value = "mincost", required = false, defaultValue = "0") String mincost,
                      @RequestParam(value = "maxcost", required = false, defaultValue = "0") String maxcost) {
        int minc = Integer.parseInt(mincost);
        int maxc = Integer.parseInt(maxcost);
        List<Product> products = productService.getProductsByCost(minc, maxc);
        model.addAttribute("products", products);
        return "index";
    }

}
