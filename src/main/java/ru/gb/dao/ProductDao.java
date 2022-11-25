package ru.gb.dao;

import org.hibernate.Session;
import ru.gb.SessionFactoryUtils;
import ru.gb.entity.Buyer;
import ru.gb.entity.Product;

import java.util.List;

public class ProductDao implements IProductDao {
    SessionFactoryUtils sessionFactoryUtils;

    public ProductDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findProductById(Long id) {
        try (Session session = sessionFactoryUtils.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAllProducts() {
        try (Session session = sessionFactoryUtils.getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void deleteProductById(Long id) {
        try (Session session = sessionFactoryUtils.getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("delete p from Product where p.id = :id").getResultList();
            session.getTransaction().commit();
        }
    }

    @Override
    public void createProduct(Product product) {
        try (Session session = sessionFactoryUtils.getCurrentSession()) {
            session.beginTransaction();
            sessionFactoryUtils.getCurrentSession().saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }
}
