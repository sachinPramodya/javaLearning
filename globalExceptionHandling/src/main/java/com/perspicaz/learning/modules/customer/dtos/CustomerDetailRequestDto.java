package com.perspicaz.learning.modules.customer.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerDetailRequestDto {
    private String name;
    private String mobile;
    private String address;

}
