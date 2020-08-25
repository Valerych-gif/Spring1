package com.geekbrains.service;

import com.geekbrains.entites.Customer;
import com.geekbrains.entites.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class MySessionFactory {

    private static SessionFactory sessionFactory;
    private static MySessionFactory instance;

    private MySessionFactory (){
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();
    }

    public static MySessionFactory getInstance(){
        if (instance==null){
            instance = new MySessionFactory();
        }
        return instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
