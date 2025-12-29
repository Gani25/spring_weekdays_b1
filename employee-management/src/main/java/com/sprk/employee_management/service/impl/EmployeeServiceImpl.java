package com.sprk.employee_management.service.impl;

import com.sprk.employee_management.entity.EmployeeInfo;
import com.sprk.employee_management.repository.EmployeeRepository;
import com.sprk.employee_management.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeInfo addEmployee(EmployeeInfo employeeInfo) {

        employeeInfo.setEmpId(0);

        EmployeeInfo savedEmployee = employeeRepository.save(employeeInfo);
        return savedEmployee;
    }
}
