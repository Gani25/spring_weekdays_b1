package com.sprk.employee_management.service.impl;

import com.sprk.employee_management.constant.EmployeeConstant;
import com.sprk.employee_management.dto.EmployeeDto;
import com.sprk.employee_management.entity.EmployeeInfo;
import com.sprk.employee_management.exception.EmailAlreadyExistsException;
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

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

//    private final EmployeeMapper employeeMapper;

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
        EmployeeInfo employeeInfo = EmployeeInfo
                .builder()
                .empId(employeeDto.getEmpId())
                .age(employeeDto.getAge())
                .email(employeeDto.getEmail())
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .gender(employeeDto.getGender())
                .department(employeeDto.getDepartment())
                .phone(employeeDto.getPhone())
                .salary(employeeDto.getSalary())
                .build();


        EmployeeInfo savedEmployee = employeeRepository.save(employeeInfo);

//        EmployeeDto savedEmployeeDto = employeeMapper.mapEmployeeInfoToEmployeeDto(savedEmployee);
        employeeDto.setEmpId(employeeInfo.getEmpId());
        // COnversion from Entity To Dto
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeInfo> allEmployees = employeeRepository.findAll();
        // stream
        List<EmployeeDto> employeeDtoList = allEmployees.stream().map((employeeInfo) ->
//                employeeMapper.mapEmployeeInfoToEmployeeDto(employeeInfo)
                EmployeeDto.builder()
                        .empId(employeeInfo.getEmpId())
                        .firstName(employeeInfo.getFirstName())
                        .lastName(employeeInfo.getLastName())
                        .email(employeeInfo.getEmail())
                        .phone(employeeInfo.getPhone())
                        .gender(employeeInfo.getGender())
                        .department(employeeInfo.getDepartment())
                        .salary(employeeInfo.getSalary())
                        .age(employeeInfo.getAge())
                        .build()
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

    /*@Override
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
    }*/
}
