package com.perspicaz.learning.modules.customer;

import com.perspicaz.learning.modules.customer.dtos.CustomerDetailRequestDto;
import com.perspicaz.learning.modules.customer.dtos.CustomerResponseDto;
import com.perspicaz.learning.modules.common.exceptions.AlreadyExists;

public interface CustomerService {
    CustomerResponseDto saveCustomer(CustomerDetailRequestDto customer) throws AlreadyExists;

    String checkMobileFirstReg(String mobile) throws AlreadyExists;



}
