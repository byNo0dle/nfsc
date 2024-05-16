package com.ufostyle.cp.domain.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    @Length(min = 30, max = 40)
    private String codeProduct;
    @NotNull
    private Integer amount;
    private Customer customer;
}
