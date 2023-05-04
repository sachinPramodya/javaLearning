package com.perspicaz.learning.modules.customer;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.perspicaz.learning.modules.common.exceptions.AlreadyExists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void whenExistingMobileTringToRegisterAlreadyExistsShouldThrown() throws Exception {

        Customer customer = new Customer();
        customer.setMobile("0719362197");
        customer.setAddress("Colombo");

        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Exception exception = assertThrows(AlreadyExists.class, () -> {
            customerService.checkMobileFirstReg("0719362197");
        });

        assertEquals("This mobile no is already registered.", exception.getMessage());

    }

}