package com.ufostyle.cp.domain.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {

    private String nameCustomer;
    private String surnames;
    private String address;
}
