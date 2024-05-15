package com.ufostyle.cp.domain.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@Document(collection = "customers")
public class Customer {

    @Id
    private BigInteger id;
    private String nameCustomer;
    private String surnames;
    private String address;
}
