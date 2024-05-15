package com.ufostyle.cp.infrastructure.controllers;

import com.ufostyle.cp.domain.entities.Customer;
import com.ufostyle.cp.domain.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @GetMapping
    public Page<Customer> getAllCustomer(Pageable pageable) {
        logger.debug("Obteniendo todos los customers");
        return customerService.findAll(pageable);
    }

    @GetMapping("/{idCustomer}")
    public Optional<Customer> getCustomerById(@PathVariable("idCustomer") String idCustomer) {
        return customerService.findById(idCustomer);
    }
}
