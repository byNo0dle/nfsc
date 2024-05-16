package com.ufostyle.cp.domain.services;

import com.ufostyle.cp.domain.entities.Customer;
import com.ufostyle.cp.domain.entities.Order;
import com.ufostyle.cp.domain.entities.Product;
import com.ufostyle.cp.domain.repositories.CustomerRepository;
import com.ufostyle.cp.domain.repositories.OrderRepository;
import com.ufostyle.cp.domain.repositories.ProductRepository;
import com.ufostyle.cp.infrastructure.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public Order findById(String idOrder) throws NotFoundException {
        Optional<Order> order = orderRepository.findById(idOrder);
        if (!order.isPresent()) {
            throw new NotFoundException("OrderId is not available");
        }
        return order.get();
    }

    public Order saveOrder(Order order) {
        Product product = productRepository.findById(order.getCodeProduct()).get();
        order.setCodeProduct(product.getId().toString());
        Customer customer = customerRepository.findById(order.getCustomer().getId().toString()).get();
        customer.setNameCustomer(order.getCustomer().getNameCustomer());
        customer.setSurnames(order.getCustomer().getSurnames());
        customer.setAddress(order.getCustomer().getAddress());
        order.setCustomer(customer);
        return orderRepository.save(order);
    }
}
