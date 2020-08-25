package com.geekbrains.controllers;

import com.geekbrains.entites.Customer;
import com.geekbrains.entites.Product;
import com.geekbrains.service.CustomerService;
import com.geekbrains.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequestMapping ("/home")
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    public void setProductRepository(ProductService productService) {
        this.productService = productService;
    }
    public void setCustomerRepository(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping ("/")
    public String home(Model model){
        return showHomePage(model);
    }

    @RequestMapping ("/customers")
    public String customers(Model model){
        return showCustomers(model);
    }

    private String showCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @RequestMapping(path = "/customer/{sid}")
    public String showCustomerById(Model model, @PathVariable("sid") int id) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        model.addAttribute("products", customer.getProducts());
        return "customer";
    }

    @RequestMapping(path = "/product/{sid}")
    public String showProductById(Model model, @PathVariable("sid") int id) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("customers", product.getCustomers());
        return "product";
    }

    @RequestMapping(path = "/customer/delete/{sid}")
    public String deleteCustomerById(Model model, @PathVariable("sid") int id) {
        customerService.deleteCustomerById(id);
        return showCustomers(model);
    }

    @RequestMapping(path = "/product/delete/{sid}")
    public String deleteProductById(Model model, @PathVariable("sid") int id) {
        productService.deleteProductById(id);
        return showHomePage(model);
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
