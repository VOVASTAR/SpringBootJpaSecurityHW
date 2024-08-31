package edu.hillel.SpringBootJpaSecurityHW.repo;

import edu.hillel.SpringBootJpaSecurityHW.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoryJpa extends JpaRepository<Order, Long> {
    Order findOrderById(Long id);
}
