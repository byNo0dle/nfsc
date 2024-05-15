package com.ufostyle.cp.infrastructure.controllers;

import com.ufostyle.cp.domain.entities.Product;
import com.ufostyle.cp.domain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{idProduct}")
    public Optional<Product> getProductById(@PathVariable("idProduct") String idProduct) {
        return productService.findById(idProduct);
    }
}
