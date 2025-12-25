package com.sprk.employee_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
public class EmployeeInfo {

    @Id
    private int empId;

    private String name;

    private String email;

    private String gender;
}
