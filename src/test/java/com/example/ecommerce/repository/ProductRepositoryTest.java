package com.example.ecommerce.repository;

import com.example.ecommerce.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void shouldSaveProduct() {
        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(new BigDecimal("99.99"));
        product.setDescription("Test Description");

        Product savedProduct = productRepository.save(product);
        assertThat(savedProduct.getId()).isNotNull();
    }

    @Test
    void shouldFindProductById() {
        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(new BigDecimal("99.99"));
        product.setDescription("Test Description");

        entityManager.persist(product);
        entityManager.flush();

        Optional<Product> found = productRepository.findById(product.getId());
        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo(product.getName());
    }

    @Test
    void shouldDeleteProduct() {
        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(new BigDecimal("99.99"));
        product.setDescription("Test Description");

        entityManager.persist(product);
        entityManager.flush();

        productRepository.deleteById(product.getId());
        Optional<Product> deleted = productRepository.findById(product.getId());
        assertThat(deleted).isEmpty();
    }
}