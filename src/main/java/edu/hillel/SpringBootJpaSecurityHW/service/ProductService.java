package edu.hillel.SpringBootJpaSecurityHW.service;

import edu.hillel.SpringBootJpaSecurityHW.entity.Product;
import edu.hillel.SpringBootJpaSecurityHW.repo.ProductRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
