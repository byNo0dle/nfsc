package com.ufostyle.cp.domain.services;

import com.ufostyle.cp.domain.entities.Product;
import com.ufostyle.cp.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(String idProduct) {
        return productRepository.findById(idProduct);
    }
}
