package ru.gb.dao;

import ru.gb.entity.Product;

import java.util.List;

public interface IProductDao {
    Product findProductById(Long id);
    List<Product> findAllProducts();
    void deleteProductById(Long id);
    void createProduct(Product product);
}
