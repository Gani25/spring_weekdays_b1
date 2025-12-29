package com.sprk.employee_management.controller;

import com.sprk.employee_management.entity.EmployeeInfo;
import com.sprk.employee_management.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// base mapping
@RequestMapping("/api/v1")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employees")
    public EmployeeInfo saveEmployee(@RequestBody EmployeeInfo employeeInfo) {

        return employeeService.addEmployee(employeeInfo);

    }
}
