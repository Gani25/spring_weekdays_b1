package com.sprk.employee_management.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class EmployeeException extends RuntimeException {

    private HttpStatus status;

    public EmployeeException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
