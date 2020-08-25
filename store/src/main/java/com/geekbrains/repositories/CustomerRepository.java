package com.geekbrains.repositories;

import com.geekbrains.entites.Customer;
import com.geekbrains.service.MySessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerRepository {

    private Session session;

    public CustomerRepository() {
    }

    private void getSession() {
        this.session = MySessionFactory.getInstance()
                .getSessionFactory()
                .getCurrentSession();
    }

    public Customer findOneById(int id) {
        getSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        session.getTransaction().commit();
        return customer;
    }

    public List<Customer> getCustomers() {
        getSession();
        session.beginTransaction();
        List<Customer> customers = session.createQuery("from Customer").getResultList();
        session.getTransaction().commit();
        return customers;
    }

    public void addCustomer(Customer customer) {
        getSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
    }

    public void deleteOneById(int id) {
        Customer customer = findOneById(id);
        getSession();
        session.beginTransaction();
        session.delete(customer);
        session.getTransaction().commit();
    }
}
