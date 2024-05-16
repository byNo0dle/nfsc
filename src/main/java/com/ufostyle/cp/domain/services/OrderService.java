package com.ufostyle.cp.domain.services;

import com.ufostyle.cp.domain.entities.Customer;
import com.ufostyle.cp.domain.entities.Order;
import com.ufostyle.cp.domain.entities.Product;
import com.ufostyle.cp.domain.repositories.CustomerRepository;
import com.ufostyle.cp.domain.repositories.OrderRepository;
import com.ufostyle.cp.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(String idOrder) {
        return orderRepository.findById(idOrder);
    }

    public Order saveOrder(Order order) {
        Product product = productRepository.findById(order.getCodeProduct()).get();
        order.setCodeProduct(product.getId().toString());
        Customer customer = customerRepository.findById(order.getCustomer().getId().toString()).get();
        customer.setNameCustomer(order.getCustomer().getNameCustomer());
        customer.setSurnames(order.getCustomer().getSurnames());
        customer.setAddress(order.getCustomer().getSurnames());
        order.setCustomer(customer);
        return orderRepository.save(order);
    }
}
