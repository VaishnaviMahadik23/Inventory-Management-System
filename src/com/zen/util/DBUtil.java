package com.zen.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Utility class for managing database connections
public class DBUtil {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/inventorydb?useSSL=false",
                "root",
                "root"
            );
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error connecting to database!");
            e.printStackTrace();
        }
        return con;
    }
}
