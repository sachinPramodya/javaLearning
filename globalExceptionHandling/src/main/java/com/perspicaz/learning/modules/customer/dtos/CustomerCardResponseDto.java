package com.perspicaz.learning.modules.customer.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class CustomerCardResponseDto {
    private String name;
    private String mobile;
    private List<String> cards;

}