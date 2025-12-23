package com.sprk.api_demo.demo_controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
// base mapping
@RequestMapping("/api/v1")
public class FirstController {

    // mappings -> /hello -> execute some method
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello from SPRK Tech";
    }

    @RequestMapping("/add")
    public int doAddition(){
        return 10+20;
    }

    @RequestMapping("/food")
    public List<String> getFavFood(){
        return Arrays.asList("Banana","Apple","Mango","Grapes");
    }

    @RequestMapping("/student")
    public Map<String,Object> getStudentInfo(){

        Map<String,Object> student = new HashMap<>();
        student.put("name","Jack");
        student.put("age",23);
        student.put("gender","Male");
        Map<String,Double> marks = new HashMap<>();
        marks.put("English",85.0);
        marks.put("Maths",62.5);
        marks.put("Science",60.0);
        marks.put("History",90.0);
        marks.put("Geography",88.0);

        student.put("marks",marks);

        student.put("Skills",Arrays.asList("Java","Python","Excel","SQL","React"));


        return student;
    }
}