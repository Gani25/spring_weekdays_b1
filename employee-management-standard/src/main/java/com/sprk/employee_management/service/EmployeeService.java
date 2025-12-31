package com.sprk.employee_management.service;


import com.sprk.employee_management.dto.EmployeeDto;
import com.sprk.employee_management.entity.EmployeeInfo;

import java.util.List;

public interface EmployeeService {
    EmployeeDto addEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();

//    EmployeeInfo getEmployeeById(int empId);
//
//    boolean deleteById(int empId);

    EmployeeDto updateEmployee(String empIdStr, EmployeeDto updatedEmployeeDto);
}
