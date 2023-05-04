package com.perspicaz.learning.modules.customer;

import com.perspicaz.learning.modules.customer.dtos.CustomerDetailRequestDto;
import com.perspicaz.learning.modules.customer.dtos.CustomerResponseDto;
import com.perspicaz.learning.modules.common.exceptions.AlreadyExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

   @Override
    public String checkMobileFirstReg(String mobile) throws AlreadyExists {
        if (customerRepository.findByMobile(mobile) != null) {
            throw new AlreadyExists("This mobile no is already registered.");
        } else {
            return "No Mobile with this no";
        }
    }

    @Override
    public CustomerResponseDto saveCustomer(CustomerDetailRequestDto customer) throws AlreadyExists {
        if (customerRepository.findByMobile(customer.getMobile()) != null) {
            throw new AlreadyExists("This mobile no is already registered.");
        } else {
            Customer newCustomer = new Customer();
            newCustomer.setAddress(customer.getAddress());
            newCustomer.setMobile(customer.getMobile());
            newCustomer.setName(customer.getName());
            Customer customerSaved = customerRepository.save(newCustomer);
            return new CustomerResponseDto(customerSaved.getName(), customerSaved.getMobile(), customerSaved.getAddress());
        }
    }

}
