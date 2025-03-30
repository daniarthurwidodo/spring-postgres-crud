package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ProductSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    private final String[] categories = {"Electronics", "Clothing", "Books", "Home & Garden", "Sports"};
    private final Random random = new Random();

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0 && "seed".equals(args[0])) {
            seedProducts();
        }
    }

    private void seedProducts() {
        System.out.println("Seeding 2000 products...");
        List<Product> products = new ArrayList<>();

        for (int i = 1; i <= 2000; i++) {
            Product product = new Product();
            product.setName("Product " + i);
            product.setDescription("Description for product " + i);
            product.setPrice(BigDecimal.valueOf(random.nextDouble() * 1000));
            product.setStock(random.nextInt(100) + 1);
            product.setCategory(categories[random.nextInt(categories.length)]);
            products.add(product);

            if (i % 100 == 0) {
                productRepository.saveAll(products);
                products.clear();
                System.out.println("Seeded " + i + " products");
            }
        }
    }
}