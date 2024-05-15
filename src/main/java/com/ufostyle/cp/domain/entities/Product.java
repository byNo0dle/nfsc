package com.ufostyle.cp.domain.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Data
@Document(collection = "products")
public class Product {

    @Id
    private BigInteger id;
    @Length(min = 10, max = 20)
    @NotBlank(message = "Please add the name")
    private String name;
    @NotNull
    private Double price;
}
