package com.sprk.api_demo.cars.impl;

import com.sprk.api_demo.cars.ICar;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class BmwCar implements ICar {

    private String brand = "BMW";
    @Override
    public String specs() {
        return "I am BMW Car";
    }

    @Override
    public String toString() {
        return "BmwCar{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
