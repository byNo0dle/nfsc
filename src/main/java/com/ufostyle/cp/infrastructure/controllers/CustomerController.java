package com.ufostyle.cp.infrastructure.controllers;

import com.ufostyle.cp.domain.entities.Customer;
import com.ufostyle.cp.domain.services.CustomerService;
import com.ufostyle.cp.infrastructure.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public Customer getCustomerById(
            @PathVariable("idCustomer") String idCustomer) throws NotFoundException {
        return customerService.findById(idCustomer);
    }

    @PostMapping
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{idCustomer}")
    public void deleteCustomer(
            @PathVariable("idCustomer") String idCustomer) {
        customerService.deleteCustomer(idCustomer);
    }
}
