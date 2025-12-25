package com.sprk.api_demo.model;

public class UserInfo {

    private String firstName;
    private String lastName;
    private String gender;
    private int age;


    public UserInfo() {
    }

    public UserInfo(String firstName, String lastName, String gender, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
