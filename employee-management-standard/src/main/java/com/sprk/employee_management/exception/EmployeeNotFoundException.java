package com.sprk.employee_management.exception;

import org.springframework.http.HttpStatus;

public class EmployeeNotFoundException extends EmployeeException{

    public EmployeeNotFoundException(String message, HttpStatus status) {
        super(status,message);
    }
}
