package com.sprk.api_demo.controller;

import com.sprk.api_demo.model.UserInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/save-user/v2")
    public String saveUserNew(@RequestBody UserInfo userInfo) {

        System.out.println(userInfo);

        return String.format("User saved Successfully, User Info Object: %s", userInfo.toString());
    }
}
