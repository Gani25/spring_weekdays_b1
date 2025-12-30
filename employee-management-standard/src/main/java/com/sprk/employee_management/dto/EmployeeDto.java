package com.sprk.employee_management.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDto {
    private Long empId;

    @NotBlank(message = "First Name Cannot Be Empty")
    private String firstName;

    @NotBlank(message = "Last Name Cannot Be Empty")
    private String lastName;

    @NotBlank(message = "Email Cannot Be Empty")
    @Email(message = "Enter Valid Email")
    private String email;

    @NotBlank(message = "Phone Cannot Be Empty")
    @Pattern(regexp = "^\\d{8,15}$", message = "Enter Valid Phone Number Minimum 8 Nums")
    private String phone;

    private String gender;

    @NotNull(message = "Age Cannot Be Empty")
    @Min(value = 1, message = "Enter age greater than 0")
    private Integer age;

    @NotNull(message = "Salary Cannot Be Empty")
    private Double salary;

    @NotBlank(message = "Department Cannot Be Empty")
    private String department;
}
