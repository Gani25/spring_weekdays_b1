package com.sprk.api_demo.cars.impl;

import com.sprk.api_demo.cars.ICar;
import org.springframework.stereotype.Component;

@Component
public class SkodaCar implements ICar {

    private String brand = "Skoda";
    @Override
    public String specs() {
        return "I am Skoda Car";
    }

    @Override
    public String toString() {
        return "SkodaCar{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
