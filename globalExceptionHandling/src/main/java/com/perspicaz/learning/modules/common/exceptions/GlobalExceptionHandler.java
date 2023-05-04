package com.perspicaz.learning.modules.common.exceptions;

import com.perspicaz.learning.modules.common.dtos.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({ValidationFailure.class})
    public ResponseEntity<?> validationException(
            ValidationFailure ex) {
        log.error("validation exception : " +
                ex.getLocalizedMessage()
        );
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .error(HttpStatus.PRECONDITION_FAILED.toString())
                        .statusCode(412)
                        .message(ex.getLocalizedMessage())
                        .build(), HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler({AlreadyExists.class})
    public ResponseEntity<?> alreadyAvailableException(
            AlreadyExists ex) {
        log.error("AlreadyExists exception : " +
                ex.getLocalizedMessage()
        );
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .error(HttpStatus.CONFLICT.toString())
                        .statusCode(409)
                        .message(ex.getLocalizedMessage())
                        .build(), HttpStatus.CONFLICT);
    }


}