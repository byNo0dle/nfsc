package com.ufostyle.cp.domain.services;

import com.ufostyle.cp.domain.entities.Order;
import com.ufostyle.cp.domain.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(String idOrder) {
        return orderRepository.findById(idOrder);
    }
}
