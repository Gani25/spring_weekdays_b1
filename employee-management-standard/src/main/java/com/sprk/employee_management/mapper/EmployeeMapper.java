package com.sprk.employee_management.mapper;

import com.sprk.employee_management.dto.EmployeeDto;
import com.sprk.employee_management.entity.EmployeeInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto mapEmployeeInfoToEmployeeDto(EmployeeInfo employeeInfo);

    EmployeeInfo mapEmployeeDtoToEmployeeInfo(EmployeeDto employeeDto);
}
