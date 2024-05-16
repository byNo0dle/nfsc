package com.ufostyle.cp.infrastructure.controllers;

import com.ufostyle.cp.domain.entities.Order;
import com.ufostyle.cp.domain.services.OrderService;
import com.ufostyle.cp.infrastructure.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @GetMapping
    public Page<Order> getAllOrders(Pageable pageable) {
        logger.debug("Obteniendo todos los orders");
        return orderService.findAll(pageable);
    }

    @GetMapping("/{idOrder}")
    public Order getOrderById(
            @PathVariable("idOrder") String idOrder) throws NotFoundException {
        return orderService.findById(idOrder);
    }

    @PostMapping
    public Order createOrder(@Valid @RequestBody Order order) {
        return orderService.saveOrder(order);
    }
}
