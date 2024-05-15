package com.ufostyle.cp.infrastructure.controllers;

import com.ufostyle.cp.domain.entities.Order;
import com.ufostyle.cp.domain.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.findAll();
    }

    @GetMapping("/{idOrder}")
    public Optional<Order> getOrderById(@PathVariable("idOrder") String idOrder) {
        return orderService.findById(idOrder);
    }
}
