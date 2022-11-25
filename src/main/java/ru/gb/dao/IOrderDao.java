package ru.gb.dao;

import ru.gb.entity.Buyer;
import ru.gb.entity.Purchase;

import java.util.List;

public interface IOrderDao {
    List<Purchase> getOrdersById(Long id);
    List<Purchase> getPurchasesFromProductId(Long id);
}
