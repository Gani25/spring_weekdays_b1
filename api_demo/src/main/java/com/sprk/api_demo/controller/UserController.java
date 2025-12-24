package com.sprk.api_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/save-user")
    public StringBuilder saveUser(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName, @RequestParam String gender, @RequestParam int age) {

        StringBuilder message = new StringBuilder("User Info\n");
        message.append("First Name: " + firstName + "\n");
        message.append("Last Name: " + lastName + "\n");
        message.append("Gender: " + gender + "\n");
        message.append("Age: " + age + "\n");
        return message;
    }
}
