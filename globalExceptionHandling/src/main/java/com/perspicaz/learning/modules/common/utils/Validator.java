package com.perspicaz.learning.modules.common.utils;

import com.perspicaz.learning.modules.common.exceptions.ValidationFailure;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
@Slf4j
public class Validator {

    //validations
    public static final String VALID_MOBILE = "^(?:7|0|(?:\\+94))[0-9]{9,10}$";

    //messages
    public static final String INVALID_MOBILE = "Invalid mobile number";

    ValidatorFactory factory;
    javax.validation.Validator validator;

    @PostConstruct
    public void postConstruct(){
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public <T> void validate(T validate) throws ValidationFailure {
        Set<ConstraintViolation<T>> violations = validator.validate(validate);
        if (!violations.isEmpty()) {
            String errorMessage = violations.stream().map( v -> (v.getPropertyPath().toString().toUpperCase() + " " + v.getMessage())).collect(Collectors.joining("|"));
            throw new ValidationFailure(errorMessage);
        }
    }

    public void validateMobile(String mobile) throws ValidationFailure{

        if(mobile == null){
            throw new ValidationFailure("Mobile can not be null");
        }

        Pattern pattern = Pattern.compile(VALID_MOBILE);
        Matcher matcher = pattern.matcher(mobile);

        if(!matcher.matches()){
            throw new ValidationFailure(INVALID_MOBILE);
        }

    }


}
