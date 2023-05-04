package com.perspicaz.learning.modules.customer;

import com.perspicaz.learning.modules.common.constants.ValidationConstants;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * customers
 */
@Entity
@Table(name = "customers")
@Getter
@Setter
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @Column(name = "customer_name", length = 100)
    private String name;

    @NotEmpty
    @Pattern(regexp = ValidationConstants.VALID_MOBILE, message = ValidationConstants.INVALID_MOBILE)
    @Column(name = "customer_mobile", length = 100)
    private String mobile;

    @NotEmpty
    @Column(name = "customer_address", length = 200)
    private String address;


}