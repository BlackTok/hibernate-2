package ru.gb;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import ru.gb.dao.BuyerDao;
import ru.gb.dao.OrderDao;
import ru.gb.dao.ProductDao;
import ru.gb.entity.Product;
import ru.gb.service.OrderService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();

        BuyerDao buyerDao = new BuyerDao(sessionFactoryUtils);
        ProductDao productDao = new ProductDao(sessionFactoryUtils);
        OrderDao orderDao = new OrderDao(sessionFactoryUtils);

        OrderService orderService = new OrderService(orderDao);

        buyerDao.getBuyerById(1L);

        System.out.println(orderDao.getOrdersById(1L));

        System.out.println(orderService.getBuyersFromOrdersByProductId(1L));
    }
}
