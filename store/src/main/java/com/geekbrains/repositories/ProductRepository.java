package com.geekbrains.repositories;

import com.geekbrains.entites.Product;
import com.geekbrains.service.MySessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepository {

    private Session session;

    public ProductRepository() {

    }

    private void getSession() {
        this.session = MySessionFactory.getInstance()
                .getSessionFactory()
                .getCurrentSession();
    }

    public Product findOneById(int id) {
        getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;
    }

    public void addProduct(Product product) {
        getSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
    }

    public void deleteOneById(int id) {
        Product product = findOneById(id);
        getSession();
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
    }

    public List<Product> getProducts() {
        getSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("from Product").getResultList();
        session.getTransaction().commit();
        return products;
    }
}
