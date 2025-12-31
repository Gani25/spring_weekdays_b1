package com.sprk.employee_management.exception;

import org.springframework.http.HttpStatus;

public class PhoneAlreadyExistsException extends EmployeeException{

    public PhoneAlreadyExistsException(String message, HttpStatus status) {
        super(status,message);
    }
}
