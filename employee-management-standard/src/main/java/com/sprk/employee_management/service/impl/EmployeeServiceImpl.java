package com.sprk.employee_management.service.impl;

import com.sprk.employee_management.constant.EmployeeConstant;
import com.sprk.employee_management.dto.EmployeeDto;
import com.sprk.employee_management.entity.EmployeeInfo;
import com.sprk.employee_management.exception.EmailAlreadyExistsException;
import com.sprk.employee_management.exception.EmployeeIdInvalidException;
import com.sprk.employee_management.exception.EmployeeNotFoundException;
import com.sprk.employee_management.exception.PhoneAlreadyExistsException;
import com.sprk.employee_management.mapper.EmployeeMapper;
import com.sprk.employee_management.repository.EmployeeRepository;
import com.sprk.employee_management.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    @Override
    @Transactional
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {

        // check if same email/phone is already registered If Yes? throw exception

        if (employeeRepository.existsByEmail(employeeDto.getEmail())) {
            // throw exception
            throw new EmailAlreadyExistsException(
                    String.format(EmployeeConstant.EMAIL_ALREADY_TAKEN, employeeDto.getEmail()),
                    HttpStatus.valueOf(EmployeeConstant.BAD_REQUEST_STATUS)
            );
        }
        if (employeeRepository.existsByPhone(employeeDto.getPhone())) {
            // throw exception
            throw new PhoneAlreadyExistsException(
                    String.format(EmployeeConstant.PHONE_ALREADY_TAKEN, employeeDto.getPhone()),
                    HttpStatus.valueOf(EmployeeConstant.BAD_REQUEST_STATUS)
            );
        }

        employeeDto.setEmpId(null);
        // Conversion from DTO to Entity
        EmployeeInfo employeeInfo = employeeMapper.mapEmployeeDtoToEmployeeInfo(employeeDto);


        EmployeeInfo savedEmployee = employeeRepository.save(employeeInfo);

        // COnversion from Entity To Dto
        EmployeeDto savedEmployeeDto = employeeMapper.mapEmployeeInfoToEmployeeDto(employeeInfo);
        return savedEmployeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeInfo> allEmployees = employeeRepository.findAll();
        // stream
        List<EmployeeDto> employeeDtoList = allEmployees.stream().map((employeeInfo) ->
                employeeMapper.mapEmployeeInfoToEmployeeDto(employeeInfo)
        ).toList();

        return employeeDtoList;
    }

    /*
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
    }*/


    @Override
    @Transactional
    public EmployeeDto updateEmployee(String empIdStr, EmployeeDto updatedEmployeeDto) {
        // check whether the empId is number or not

        if (!Pattern.matches("^\\d+$", empIdStr)) {
            throw new EmployeeIdInvalidException(
                    String.format(EmployeeConstant.EMP_ID_INVALID, empIdStr),
                    HttpStatus.valueOf(EmployeeConstant.BAD_REQUEST_STATUS)
            );
        }

        Long empId = Long.parseLong(empIdStr);
        // find by empId (Long)
        EmployeeInfo existingEmployeeInfo = employeeRepository.findById(empId)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                String.format(EmployeeConstant.EMP_NOT_FOUND, empIdStr),
                                HttpStatus.valueOf(EmployeeConstant.BAD_REQUEST_STATUS)
                        )
                );

        if (employeeRepository.existsByEmailAndEmpIdNot(updatedEmployeeDto.getEmail(), empId)) {
            // throw exception
            throw new EmailAlreadyExistsException(
                    String.format(EmployeeConstant.EMAIL_ALREADY_TAKEN, updatedEmployeeDto.getEmail()),
                    HttpStatus.valueOf(EmployeeConstant.BAD_REQUEST_STATUS)
            );
        }

        if (employeeRepository.existsByPhoneAndEmpIdNot(updatedEmployeeDto.getPhone(), empId)) {
            // throw exception
            throw new PhoneAlreadyExistsException(
                    String.format(EmployeeConstant.PHONE_ALREADY_TAKEN, updatedEmployeeDto.getPhone()),
                    HttpStatus.valueOf(EmployeeConstant.BAD_REQUEST_STATUS)
            );
        }

        EmployeeInfo updatedEmployeeInfo = employeeMapper.mapEmployeeDtoToEmployeeInfo(updatedEmployeeDto);
        updatedEmployeeInfo.setEmpId(empId);
        EmployeeInfo newUpdatedEmployeeInfo = employeeRepository.save(updatedEmployeeInfo);

        return employeeMapper.mapEmployeeInfoToEmployeeDto(newUpdatedEmployeeInfo);
    }
}
