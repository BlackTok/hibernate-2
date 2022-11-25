package ru.gb.dao;

import ru.gb.entity.Buyer;

import java.util.List;

public interface IBuyerDao {
    Buyer getBuyerById(Long id);
    List<Buyer> getAllBuyers();
    void deleteBuyerById(Long id);
    void createBuyer(Buyer buyer);
}
