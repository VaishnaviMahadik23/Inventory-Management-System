package com.zen.dao;

import com.zen.model.Product;
import com.zen.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Implementation of IProductDAO using JDBC
public class ProductDAOImpl implements IProductDAO {
    private Connection conn;

    public ProductDAOImpl() throws SQLException {
        this.conn = DBUtil.getConnection(); // Establish DB connection
    }

    @Override
    public void addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO products (id, name, category, quantity, price) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, product.getId());
        ps.setString(2, product.getName());
        ps.setString(3, product.getCategory());
        ps.setInt(4, product.getQuantity());
        ps.setDouble(5, product.getPrice());
        ps.executeUpdate();
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) { // Loop through result set
            products.add(new Product(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("category"),
                rs.getInt("quantity"),
                rs.getDouble("price")
            ));
        }
        return products;
    }

    @Override
    public Product getProductById(int id) throws SQLException {
        String sql = "SELECT * FROM products WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            return new Product(rs.getInt("id"), rs.getString("name"),
                               rs.getString("category"), rs.getInt("quantity"),
                               rs.getDouble("price"));
        }
        return null;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        String sql = "UPDATE products SET name=?, category=?, quantity=?, price=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, product.getName());
        ps.setString(2, product.getCategory());
        ps.setInt(3, product.getQuantity());
        ps.setDouble(4, product.getPrice());
        ps.setInt(5, product.getId());
        ps.executeUpdate();
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
        String sql = "DELETE FROM products WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
