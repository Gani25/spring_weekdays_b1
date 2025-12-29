package com.sprk.employee_management.service.impl;

import com.sprk.employee_management.entity.EmployeeInfo;
import com.sprk.employee_management.repository.EmployeeRepository;
import com.sprk.employee_management.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<EmployeeInfo> getAllEmployees() {
        List<EmployeeInfo> allEmployees = employeeRepository.findAll();
        return allEmployees;
    }

    @Override
    public EmployeeInfo getEmployeeById(int empId) {
        return employeeRepository.findById(empId).orElse(null);

    }

    @Override
    public boolean deleteById(int empId) {
        EmployeeInfo existingEmployee = employeeRepository.findById(empId).orElse(null);
        if(existingEmployee != null) {
//            employeeRepository.deleteById(empId);
            employeeRepository.delete(existingEmployee);
            return true;
        }
        return false;
    }
}
