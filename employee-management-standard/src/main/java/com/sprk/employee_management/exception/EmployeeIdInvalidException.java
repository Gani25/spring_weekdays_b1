package com.sprk.employee_management.exception;

import org.springframework.http.HttpStatus;

public class EmployeeIdInvalidException extends EmployeeException{

    public EmployeeIdInvalidException(String message, HttpStatus status) {
        super(status,message);
    }
}
