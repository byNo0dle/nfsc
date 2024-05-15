package com.ufostyle.cp.infrastructure.controllers;

import com.ufostyle.cp.domain.entities.Product;
import com.ufostyle.cp.domain.services.ProductService;
import com.ufostyle.cp.infrastructure.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @GetMapping
    public Page<Product> getAllProducts(Pageable pageable) {
        logger.debug("Obteniendo todos los products");
        return productService.findAll(pageable);
    }

    @GetMapping("/{idProduct}")
    public Product getProductById(
            @PathVariable("idProduct") String idProduct) throws NotFoundException {
        return productService.findById(idProduct);
    }

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.saveProduct(product);
    }
}
