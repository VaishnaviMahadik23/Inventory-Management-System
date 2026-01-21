package com.zen.service;

import com.zen.model.Product;
import java.util.List;

// Thread to monitor low stock products
public class StockMonitor extends Thread {
    private ProductService service;

    public StockMonitor(ProductService service) {
        this.service = service;
    }

    @Override
    public void run() {
        while(true) {
            try {
                List<Product> products = service.getAllProducts();
                for(Product p : products) {
                    if(p.getQuantity() < 5) {
                        System.out.println("⚠ Low stock alert: " + p.getName());
                    }
                }
                Thread.sleep(10000); // check every 10 seconds
            } catch(Exception e) {
                System.out.println("Error in StockMonitor: " + e.getMessage());
            }
        }
    }
}
