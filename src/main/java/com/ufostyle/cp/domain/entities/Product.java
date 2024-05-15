package com.ufostyle.cp.domain.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@Document(collection = "products")
public class Product {

    @Id
    private BigInteger id;
    private String name;
    private Double price;
}
