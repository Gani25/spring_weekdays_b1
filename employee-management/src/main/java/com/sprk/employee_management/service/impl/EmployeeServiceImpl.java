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

    @Override
    public EmployeeInfo updateEmployee(int empId, EmployeeInfo employeeInfo) {
        EmployeeInfo existingEmployee = employeeRepository.findById(empId).orElse(null);
        if(existingEmployee != null) {
            if(employeeInfo.getName() != null && !employeeInfo.getName().isBlank()){
                existingEmployee.setName(employeeInfo.getName());
            }
            if(employeeInfo.getGender() != null && !employeeInfo.getGender().isBlank()){
                existingEmployee.setGender(employeeInfo.getGender());
            }
            if (employeeInfo.getEmail() != null && !employeeInfo.getEmail().isBlank()){
                existingEmployee.setEmail(employeeInfo.getEmail());
            }

            EmployeeInfo updatedEmployee = employeeRepository.save(existingEmployee);
            return updatedEmployee;
        }
        return null;
    }
}
