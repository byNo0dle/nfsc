package com.ufostyle.cp.domain.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "orders")
public class Orders {

    private Long nroOrder;
    private Long codeProduct;
    private Integer amount;
    private Customers customers;
}
