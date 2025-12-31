package com.sprk.employee_management.exception;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExistsException extends EmployeeException{

    public EmailAlreadyExistsException(String message, HttpStatus status) {
        super(status,message);
    }
}
