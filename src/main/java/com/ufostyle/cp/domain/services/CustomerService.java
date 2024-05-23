package com.ufostyle.cp.domain.services;

import com.ufostyle.cp.domain.entities.Customer;
import com.ufostyle.cp.domain.repositories.CustomerRepository;
import com.ufostyle.cp.infrastructure.exceptions.NotFoundException;
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

    public Customer findById(String idCustomer) throws NotFoundException {
        Optional<Customer> customer = customerRepository.findById(idCustomer);
        if (!customer.isPresent()) {
            throw new NotFoundException("CustomerId is not available");
        }
        return customer.get();
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
