package ru.gb.dao;

import org.hibernate.Session;
import ru.gb.SessionFactoryUtils;
import ru.gb.entity.Buyer;
import ru.gb.entity.Purchase;

import java.util.ArrayList;
import java.util.List;

public class OrderDao implements IOrderDao {
    SessionFactoryUtils sessionFactoryUtils;

    public OrderDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public List<Purchase> getOrdersById(Long id) {
        try (Session session = sessionFactoryUtils.getCurrentSession()) {
            session.beginTransaction();
            List<Purchase> purchases = session
                    .createQuery("from Purchase where buyer.id = :id")
                    .setParameter("id", id)
                    .getResultList();
            session.close();
            return purchases;
        }
    }

    @Override
    public List<Purchase> getPurchasesFromProductId(Long id) {
        try (Session session = sessionFactoryUtils.getCurrentSession()) {
            session.beginTransaction();
            List<Purchase> purchases = session
                    .createQuery("from Purchase where product.id = :id")
                    .setParameter("id", id)
                    .getResultList();
            session.close();

            return purchases;
        }
    }
}
