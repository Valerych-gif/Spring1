package com.geekbrains.service;

import com.geekbrains.entites.Customer;
import com.geekbrains.entites.Product;
import com.geekbrains.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public void setProductRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerService() {
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findOneById(id);
    }

    public void addCustomer(Customer customer){
        customerRepository.addCustomer(customer);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.getCustomers();
    }


    public void deleteCustomerById(int id) {
        customerRepository.deleteOneById(id);
    }
}
