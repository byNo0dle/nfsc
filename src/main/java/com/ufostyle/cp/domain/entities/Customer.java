package com.ufostyle.cp.domain.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
public class Customer {

    @Id
    private String id;
    @Length(min = 3, max = 20)
    private String nameCustomer;
    @Length(min = 10, max = 20)
    private String surnames;
    @Length(min = 10, max = 40)
    private String address;
}
