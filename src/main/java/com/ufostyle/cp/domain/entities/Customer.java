package com.ufostyle.cp.domain.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.math.BigInteger;

@Data
@Document(collection = "customers")
public class Customer {

    @Id
    private BigInteger id;
    @NotBlank(message = "Please add the nameCustomer")
    private String nameCustomer;
    @Length(min = 10, max = 20)
    @NotBlank(message = "Please add the surnames")
    private String surnames;
    @Length(min = 10, max = 40)
    @NotBlank(message = "Please add the address")
    private String address;
}
