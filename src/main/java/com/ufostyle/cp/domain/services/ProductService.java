package com.ufostyle.cp.domain.services;

import com.ufostyle.cp.domain.entities.Product;
import com.ufostyle.cp.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Optional<Product> findById(String idProduct) {
        return productRepository.findById(idProduct);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
