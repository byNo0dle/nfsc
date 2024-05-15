package com.ufostyle.cp.infrastructure.controllers;

import com.ufostyle.cp.domain.entities.Customer;
import com.ufostyle.cp.domain.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomer() {
        return customerService.findAll();
    }

    @GetMapping("/{idCustomer}")
    public Optional<Customer> getCustomerById(@PathVariable("idCustomer") String idCustomer) {
        return customerService.findById(idCustomer);
    }
}
