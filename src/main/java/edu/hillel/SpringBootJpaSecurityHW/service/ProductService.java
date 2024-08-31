package edu.hillel.SpringBootJpaSecurityHW.service;

import edu.hillel.SpringBootJpaSecurityHW.entity.Product;
import edu.hillel.SpringBootJpaSecurityHW.repo.ProductRepositoryJpa;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Slf4j
@AllArgsConstructor

@Service
public class ProductService {

    private final ProductRepositoryJpa productRepositoryJpa;

    public List<Product> getAllProducts() {
        return productRepositoryJpa.findAll();
    }

    public Product getProductById(Long id) {
        return productRepositoryJpa.findById(id).orElseThrow();
    }

    public Product addProduct(String name, double cost) {
        Product newProduct = Product.builder()
                .name(name)
                .cost(cost)
                .orders(new HashSet<>())
                .build();
        log.info("New product {} is created", newProduct);
        productRepositoryJpa.save(newProduct);
        log.info("New product {} is save in BD", newProduct);
        return newProduct;
    }

    public void removeProduct(Long id) {
        productRepositoryJpa.deleteById(id);
    }
}
