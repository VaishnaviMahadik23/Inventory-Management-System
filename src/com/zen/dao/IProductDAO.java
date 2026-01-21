package com.zen.dao;

import com.zen.model.Product;
import java.sql.SQLException;
import java.util.List;

// Interface defining CRUD operations
public interface IProductDAO {
    void addProduct(Product product) throws SQLException; // Adds a product to DB
    List<Product> getAllProducts() throws SQLException;   // Retrieves all products
    Product getProductById(int id) throws SQLException;   // Finds product by ID
    void updateProduct(Product product) throws SQLException; // Updates product info
    void deleteProduct(int id) throws SQLException;       // Deletes product by ID
}
