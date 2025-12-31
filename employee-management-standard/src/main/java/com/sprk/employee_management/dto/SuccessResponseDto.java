package com.sprk.employee_management.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class SuccessResponseDto<D> {

    private int status;

    private String message;

    private D data;


}
