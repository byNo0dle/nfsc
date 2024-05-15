package com.ufostyle.cp.domain.services;

import com.ufostyle.cp.domain.entities.Product;
import com.ufostyle.cp.domain.repositories.ProductRepository;
import com.ufostyle.cp.infrastructure.exceptions.NotFoundException;
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

    public Product findById(String idProduct) throws NotFoundException {
        Optional<Product> product = productRepository.findById(idProduct);
        if (!product.isPresent()) {
            throw new NotFoundException("ProductId is not available");
        }
        return product.get();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
