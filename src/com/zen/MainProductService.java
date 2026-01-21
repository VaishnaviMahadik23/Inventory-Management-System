package com.zen;

import com.zen.dao.ProductDAOImpl;
import com.zen.model.Product;
import com.zen.service.ProductService;
import com.zen.service.StockMonitor; // Multithreading class
import java.util.Scanner;
import java.util.List;

// Menu-driven Inventory Management System
public class MainProductService {
    public static void main(String[] args) {
        try {
            // Initialize service layer with DAO implementation
            ProductService service = new ProductService(new ProductDAOImpl());

            // Start background thread to monitor low stock
            StockMonitor monitor = new StockMonitor(service);
            monitor.start();

            Scanner sc = new Scanner(System.in);

            while (true) { 
            	// Loop for menu
                System.out.println("===== Inventory Management System =====");
                System.out.println("1. Add Product");
                System.out.println("2. View Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Search Product");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) { // Switch-case for menu options
                    case 1:
                        // Adds a new product to inventory
                        System.out.println("Enter ID:");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Name:");
                        String name = sc.nextLine();
                        System.out.println("Enter Category:");
                        String category = sc.nextLine();
                        System.out.println("Enter Quantity:");
                        int qty = sc.nextInt();
                        System.out.println("Enter Price:");
                        double price = sc.nextDouble();

                        Product p = new Product(id, name, category, qty, price);
                        service.addProduct(p); 
                        System.out.println("Product added!");
                        break;

                    case 2:
                        // Retrieves and displays all products
                        List<Product> products = service.getAllProducts();
                        products.forEach(System.out::println); // Using Collection + Lambda
                        break;

                    case 3:
                        // Updates product details
                        System.out.println("Enter ID to update:");
                        int updateId = sc.nextInt();
                        sc.nextLine();
                        Product existing = service.getProductById(updateId);
                        if (existing != null) {
                            System.out.println("Enter new Name:");
                            String newName = sc.nextLine();
                            System.out.println("Enter new Category:");
                            String newCategory = sc.nextLine();
                            System.out.println("Enter new Quantity:");
                            int newQty = sc.nextInt();
                            System.out.println("Enter new Price:");
                            double newPrice = sc.nextDouble();

                            Product updated = new Product(updateId, newName, newCategory, newQty, newPrice);
                            service.updateProduct(updated);
                            System.out.println("Product updated!");
                        } else {
                            System.out.println("Product not found!");
                        }
                        break;

                    case 4:
                        // Deletes product by ID
                        System.out.println("Enter ID to delete:");
                        int deleteId = sc.nextInt();
                        service.deleteProduct(deleteId);
                        System.out.println("Product deleted!");
                        break;

                    case 5:
                        // Searches product by ID
                        System.out.println("Enter ID to search:");
                        int searchId = sc.nextInt();
                        Product found = service.getProductById(searchId);
                        System.out.println(found != null ? found : "Product not found!");
                        break;

                    case 6:
                        // Exits the application gracefully
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace(); // General exception handling
        }

    }
}
