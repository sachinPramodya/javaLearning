package com.perspicaz.learning.modules.common.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {
    private int statusCode;
    private String error;
    private String message;
}

