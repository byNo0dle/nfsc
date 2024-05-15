package com.ufostyle.cp.domain.services;

import com.ufostyle.cp.domain.entities.Customer;
import com.ufostyle.cp.domain.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    public Optional<Customer> findById(String idCustomer) {
        return customerRepository.findById(idCustomer);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
