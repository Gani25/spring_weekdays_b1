package com.sprk.api_demo.controller;

import com.sprk.api_demo.model.UserInfo;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@RestController
public class UserController2 {

    private List<UserInfo> users;

    @PostConstruct
    public void init() {

        System.out.println("Initializing users in UserController2");
        users = new ArrayList<>();
        users.add(new UserInfo("Rohit", "Sharma", "Male", 40));
        users.add(new UserInfo("Ashish", "Gupta", "Male", 24));
        users.add(new UserInfo("Anjali", "Raibole", "Female", 20));
        users.add(new UserInfo("Abdul", "Gani", "Male", 26));
    }


    @GetMapping("/users")
    public List<UserInfo> getAllUsers() {



        return users;
    }


    @GetMapping("/users/{index}")
    public ResponseEntity<?> getUserByIndex(@PathVariable("index") String indexStr) {

        if (!Pattern.matches("\\d+", indexStr.replace("-",""))) {


//            return new ResponseEntity<>("Index should be number only",HttpStatus.BAD_REQUEST);

            throw new RuntimeException("Index should be number only");

//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Index should be number only");

        }



        int index = Integer.parseInt(indexStr);
        if (index < 0) {
            throw new RuntimeException("Index cannot be negative");
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Index cannot be negative");
        }
        if (index >= users.size()) {

            throw new RuntimeException("Index cannot be greater than the number of users");
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Index cannot be greater than the number of users");
        }

//        return ResponseEntity.status(HttpStatus.OK).body(users.get(index));
        return ResponseEntity.ok(users.get(index));
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Clearing users in UserController2");
        users.clear();
//        users = null;
    }

}
