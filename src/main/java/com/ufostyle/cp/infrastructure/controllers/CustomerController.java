package com.ufostyle.cp.infrastructure.controllers;

import com.ufostyle.cp.domain.entities.Customer;
import com.ufostyle.cp.domain.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public Page<Customer> getAllCustomer(Pageable pageable) {
        return customerService.findAll(pageable);
    }

    @GetMapping("/{idCustomer}")
    public Optional<Customer> getCustomerById(@PathVariable("idCustomer") String idCustomer) {
        return customerService.findById(idCustomer);
    }
}
