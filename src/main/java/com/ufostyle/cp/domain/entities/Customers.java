package com.ufostyle.cp.domain.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
public class Customers {

    private String nameCustomer;
    private String surnames;
    private String address;
}
