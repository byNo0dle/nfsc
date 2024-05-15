package com.ufostyle.cp.infrastructure.controllers;

import com.ufostyle.cp.domain.entities.Product;
import com.ufostyle.cp.domain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public Page<Product> getAllProducts(Pageable pageable) {
        return productService.findAll(pageable);
    }

    @GetMapping("/{idProduct}")
    public Optional<Product> getProductById(@PathVariable("idProduct") String idProduct) {
        return productService.findById(idProduct);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
}
