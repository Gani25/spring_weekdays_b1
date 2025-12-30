package com.sprk.employee_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity(name = "employee")
//@Table(name = "employee_sprk")
public class EmployeeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @Column(name = "emp_name", nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

//    @Column(columnDefinition = " enum('Male', 'Female', 'Other')")
    private String gender;
}
