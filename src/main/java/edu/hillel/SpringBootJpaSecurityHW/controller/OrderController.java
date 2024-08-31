package edu.hillel.SpringBootJpaSecurityHW.controller;


import edu.hillel.SpringBootJpaSecurityHW.entity.Order;
import edu.hillel.SpringBootJpaSecurityHW.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/get-all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/add-order")
    public String getFormForAddOrder() {
        return "addOrder";
    }

    @PostMapping("/add-order")
    public void addOrder(@RequestParam List<Long> ids) {
        orderService.addOrder(ids);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
    }
}
