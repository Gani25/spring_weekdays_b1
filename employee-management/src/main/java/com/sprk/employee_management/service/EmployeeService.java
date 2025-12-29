package com.sprk.employee_management.service;


import com.sprk.employee_management.entity.EmployeeInfo;

import java.util.List;

public interface EmployeeService {
    EmployeeInfo addEmployee(EmployeeInfo employeeInfo);

    List<EmployeeInfo> getAllEmployees();

    EmployeeInfo getEmployeeById(int empId);

    boolean deleteById(int empId);
}
