package com.sprk.api_demo.cars.impl;

import com.sprk.api_demo.cars.ICar;
import org.springframework.stereotype.Component;

@Component
public class TataCar implements ICar {

    private String brand = "Tata";
    @Override
    public String specs() {
        return "I am Tata Car";
    }

    @Override
    public String toString() {
        return "TataCar{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
