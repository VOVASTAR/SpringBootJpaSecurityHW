package edu.hillel.SpringBootJpaSecurityHW.service;

import edu.hillel.SpringBootJpaSecurityHW.entity.Order;
import edu.hillel.SpringBootJpaSecurityHW.entity.Product;
import edu.hillel.SpringBootJpaSecurityHW.repo.OrderRepositoryJpa;
import edu.hillel.SpringBootJpaSecurityHW.repo.ProductRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service

@AllArgsConstructor
public class OrderService {

    private final OrderRepositoryJpa orderRepository;
    private final ProductRepositoryJpa productRepositoryJpa;


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findOrderById(id);
    }

    @Transactional
    public void addOrder(List<Long> products) {
        LocalDateTime now = LocalDateTime.now();
        List<Product> productList = productRepositoryJpa.findAllById(products);
        double orderSum = productList.stream()
                .mapToDouble(Product::getCost)
                .sum();
        Order newOrder = Order.builder()
                .date(now)
                .cost(orderSum)
                .products(productList)
                .build();
        orderRepository.save(newOrder);
    }

    @Transactional
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

}
