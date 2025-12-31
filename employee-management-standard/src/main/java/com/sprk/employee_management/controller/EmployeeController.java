package com.sprk.employee_management.controller;

import com.sprk.employee_management.constant.EmployeeConstant;
import com.sprk.employee_management.dto.EmployeeDto;
import com.sprk.employee_management.dto.ResponseDto;
import com.sprk.employee_management.dto.SuccessResponseDto;
import com.sprk.employee_management.entity.EmployeeInfo;
import com.sprk.employee_management.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// base mapping
@RequestMapping("/api/v1")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<ResponseDto<SuccessResponseDto<EmployeeDto>>> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto) {

        System.out.println(employeeDto);
        EmployeeDto savedEmployeeDto = employeeService.addEmployee(employeeDto);

        ResponseDto<SuccessResponseDto<EmployeeDto>> responseDto = new ResponseDto<>();

        SuccessResponseDto<EmployeeDto> successResponseDto = new SuccessResponseDto<>();
        successResponseDto.setData(savedEmployeeDto);
        successResponseDto.setMessage(String.format(EmployeeConstant.INSERT_MESSAGE,savedEmployeeDto.getEmpId()));
        successResponseDto.setStatus(EmployeeConstant.INSERT_STATUS);

        responseDto.setResponse(successResponseDto);


        return ResponseEntity.status(HttpStatus.valueOf(EmployeeConstant.INSERT_STATUS)).body(responseDto);
    }

    /*
    @GetMapping("/employees")

    public List<EmployeeInfo> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{empId}")
    public EmployeeInfo getEmployeeById(@PathVariable int empId) {

        return employeeService.getEmployeeById(empId);
    }

    @DeleteMapping("/employees/{empId}")
    public String deleteEmployeeById(@PathVariable int empId) {

        boolean result = employeeService.deleteById(empId);
        if (result) {
            return String.format("Employee with id = %d deleted successfully", empId);
        }
        return String.format("Employee with id = %d could not found!!", empId);
    }

//    @PutMapping("/employees/{empId}")
//    public EmployeeInfo updateEmployee(@PathVariable int empId, @RequestBody EmployeeInfo employeeInfo) {
//
//        return employeeService.updateEmployee(empId, employeeInfo);
//    }
    */
}
