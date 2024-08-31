package edu.hillel.SpringBootJpaSecurityHW.repo;

import edu.hillel.SpringBootJpaSecurityHW.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryJpa extends JpaRepository<Product, Long> {
}
