package com.sprk.api_demo.controller;

import com.sprk.api_demo.cars.ICar;
import com.sprk.api_demo.showroom.CarShowroom;
import com.sprk.api_demo.showroom.CarShowroom2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/showroom")
public class CarController2 {
    

    private final CarShowroom2 carShowroom2;

    @Autowired
    public CarController2(CarShowroom2 carShowroom2) {
        this.carShowroom2 = carShowroom2;
    }

    @GetMapping("/all-brands")
    public List<ICar> getAllCars(){

        System.out.println(carShowroom2.getiCar());
        return carShowroom2.getiCar();
    }

    
}
