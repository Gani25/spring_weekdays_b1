package com.sprk.employee_management.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorResponseDto<E> {

    private HttpStatus status;

    private E errorMessage;

    private String apiPath;

    private LocalDateTime timestamp;

}
