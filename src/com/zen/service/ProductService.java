package com.zen.service;

import com.zen.dao.IProductDAO;
import com.zen.model.Product;
import java.sql.SQLException;
import java.util.List;

// Handles business logic and validations
public class ProductService {
    private IProductDAO productDAO;

    public ProductService(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void addProduct(Product product) throws SQLException {
        if(product.getQuantity() < 0 || product.getPrice() < 0) {
            throw new IllegalArgumentException("Quantity and price must be positive!");
        }
        productDAO.addProduct(product);
    }

    public List<Product> getAllProducts() throws SQLException {
        return productDAO.getAllProducts();
    }

    public Product getProductById(int id) throws SQLException {
        return productDAO.getProductById(id);
    }

    public void updateProduct(Product product) throws SQLException {
        productDAO.updateProduct(product);
    }

    public void deleteProduct(int id) throws SQLException {
        productDAO.deleteProduct(id);
    }
}
