package ru.gb.dao;

import org.hibernate.Session;
import ru.gb.SessionFactoryUtils;
import ru.gb.entity.Buyer;

import java.util.List;

public class BuyerDao implements IBuyerDao {
    SessionFactoryUtils sessionFactoryUtils;

    public BuyerDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Buyer getBuyerById(Long id) {
        try (Session session = sessionFactoryUtils.getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            System.out.println(buyer);
            session.close();
            return buyer;
        }
    }

    @Override
    public List<Buyer> getAllBuyers() {
        try (Session session = sessionFactoryUtils.getCurrentSession()) {
            session.beginTransaction();
            List<Buyer> buyers = session.createQuery("from Buyer").list();
            session.getTransaction().commit();
            return buyers;
        }
    }

    @Override
    public void deleteBuyerById(Long id) {
        try (Session session = sessionFactoryUtils.getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("delete b from Buyer where b.id = :id");
            session.getTransaction().commit();
        }
    }

    @Override
    public void createBuyer(Buyer buyer) {
        try (Session session = sessionFactoryUtils.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(buyer);
            session.getTransaction().commit();
        }
    }


}
