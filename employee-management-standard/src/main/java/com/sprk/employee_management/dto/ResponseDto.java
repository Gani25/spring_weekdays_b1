package com.sprk.employee_management.dto;

import lombok.Data;

@Data
public class ResponseDto<E> {

    private E response;
}
