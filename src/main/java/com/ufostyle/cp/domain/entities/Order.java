package com.ufostyle.cp.domain.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@Document(collection = "orders")
public class Order {

    @Id
    private BigInteger id;
    private String codeProduct;
    private Integer amount;
    private Customer customer;
}
