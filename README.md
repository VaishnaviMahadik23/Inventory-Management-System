📦 Inventory Management System (JDBC + Java)
📖 Overview
The Inventory Management System is a menu-driven Java application built using JDBC.
It demonstrates CRUD operations (Create, Read, Update, Delete) on a product database, while showcasing OOP concepts, exception handling, multithreading, and collections.

This project is designed for learning and evaluation purposes, highlighting clean coding practices and Java fundamentals.

🎯 Features
Add new products to inventory

View all products

Update product details

Delete products by ID

Search products by ID

Background Stock Monitor Thread alerts when product quantity is low

Exception handling for invalid inputs and database errors

Uses DAO pattern for separation of concerns

🧑‍💻 Concepts Demonstrated
Interface & Implementing Class → IProductDAO and ProductDAOImpl

OOP Principles → Encapsulation, Abstraction, Polymorphism

Loops → Menu loop (while(true)), ResultSet iteration (while(rs.next()))

Collection Framework → List<Product> with lambda printing

Switch Case → Menu-driven user choices

Multithreading → StockMonitor thread for low-stock alerts

Exception Handling → try-catch for SQL and input validation

JDBC → Connection, PreparedStatement, ResultSet for CRUD operations
