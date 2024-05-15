package com.ufostyle.cp.domain.services;

import com.ufostyle.cp.domain.entities.Customer;
import com.ufostyle.cp.domain.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(String idCustomer) {
        return customerRepository.findById(idCustomer);
    }
}
