package com.sprk.employee_management.controller.advice;

import com.sprk.employee_management.dto.ErrorResponseDto;
import com.sprk.employee_management.dto.ResponseDto;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class EmployeeAdvice extends ResponseEntityExceptionHandler {
    private final View error;

    public EmployeeAdvice(View error) {
        this.error = error;
    }

    @Override
    protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String,String> validationErrors = new HashMap<>();

        BindingResult bindingResult = ex.getBindingResult();

        List<ObjectError> allErrors = bindingResult.getAllErrors();

        for (ObjectError objectError : allErrors) {
            FieldError fieldError = (FieldError) objectError;
            String fieldName = fieldError.getField();
            String errorMessage = objectError.getDefaultMessage();
            validationErrors.put(fieldName, errorMessage);
        }

        // Creating Our ResponseDto Object
        ResponseDto<ErrorResponseDto<Map<String,String>>> responseDto = new ResponseDto<>();

        // Since Response Dto will accept Object of ErrorResponseDto so creating Object
        ErrorResponseDto<Map<String,String>> errorResponseDto = new ErrorResponseDto<>();

        // Filling all the values of ErrorResponseDto Object
        errorResponseDto.setTimestamp(LocalDateTime.now());
        errorResponseDto.setStatus(HttpStatus.valueOf(status.value()));
        errorResponseDto.setApiPath(request.getDescription(true));
        errorResponseDto.setErrorMessage(validationErrors);

        // Adding filled errorResponseDto Object to our ResponseDto Object
        responseDto.setResponse(errorResponseDto);


        // Finally returning ResponseEntity Object with our filled ResponseDto Object
        return ResponseEntity.status(status).body(responseDto);
    }
}
