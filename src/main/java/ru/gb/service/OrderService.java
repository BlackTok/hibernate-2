package ru.gb.service;

import ru.gb.dao.OrderDao;
import ru.gb.entity.Buyer;
import ru.gb.entity.Purchase;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Buyer> getBuyersFromOrdersByProductId(Long id) {
        List<Purchase> purchases = orderDao.getPurchasesFromProductId(id);
        List<Buyer> buyers = new ArrayList<>();

        for (int i = 0; i < purchases.size(); i++) {
            Buyer buyer = purchases.get(i).getBuyer();
            if (!buyers.contains(buyer))
                buyers.add(buyer);
        }

        return buyers;
    }
}
