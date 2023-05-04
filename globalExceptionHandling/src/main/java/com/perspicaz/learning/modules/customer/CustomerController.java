package com.perspicaz.learning.modules.customer;

import com.perspicaz.learning.modules.customer.dtos.CustomerDetailRequestDto;
import com.perspicaz.learning.modules.common.exceptions.AlreadyExists;
import com.perspicaz.learning.modules.common.exceptions.ValidationFailure;
import com.perspicaz.learning.modules.common.utils.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("${spring.data.rest.base-path}/customer")
public class CustomerController {

    private final CustomerService customerService;
    private  final Validator validator;

    @GetMapping("/checkMobile")
    public ResponseEntity<?> checkMobileNo(@RequestParam(value = "mobile", required = true) String mobile) throws ValidationFailure, AlreadyExists {
        log.trace("checking mobile" + mobile);
        validator.validateMobile(mobile);
        return ResponseEntity.ok(customerService.checkMobileFirstReg(mobile));
    }

    @PostMapping
    public ResponseEntity<?> saveResponse(@RequestBody CustomerDetailRequestDto customer) throws ValidationFailure, AlreadyExists {
        log.trace("customer saving" + customer.getName());
        validator.validateMobile(customer.getMobile());
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }


}
