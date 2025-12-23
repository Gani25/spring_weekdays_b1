package com.sprk.api_demo.demo_controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class SecondController {

    // addition of 2 numbers accept numbers from user (Request Params)
    @GetMapping("/add")
    public double doAddition(@RequestParam("num1") double n1, @RequestParam(value = "num2", defaultValue = "0") double n2) {
        return n1 + n2;
    }

    @GetMapping("/subt/{n1}/{num2}")
    public int subtraction(@PathVariable int n1, @PathVariable("num2") int n2) {
        return n1 - n2;
    }
}
