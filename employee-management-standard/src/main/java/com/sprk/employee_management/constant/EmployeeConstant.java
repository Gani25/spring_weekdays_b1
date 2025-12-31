package com.sprk.employee_management.constant;

public class EmployeeConstant {


    public static final int INSERT_STATUS = 201;
    public static final int SUCCESS_STATUS = 200;
    public static final int BAD_REQUEST_STATUS = 400;


    public static final String INSERT_MESSAGE = "Employee Save Successfully, Emp Is = %d";
    public static final String EMP_UPDATE_MESSAGE = "Employee with id: %s updated successfully!!";
    public static final String FETCH_ALL_MESSAGE = "All Employees Fetched Successfully";
    public static final String EMAIL_ALREADY_TAKEN = "Email: %s Already Taken. Please try new email";
    public static final String PHONE_ALREADY_TAKEN = "Phone: %s Already Taken. Please try new phone number";
    public static final String EMP_ID_INVALID = "Employee id: %s is incorrect. Pass Number Only";
    public static final String EMP_NOT_FOUND = "Employee id: %s not found!!";
}
