package com.sprk.api_demo.controller;

import com.sprk.api_demo.showroom.CarShowroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/showroom")
public class CarController {

    private final CarShowroom carShowroom;

    @Autowired
    public CarController(CarShowroom carShowroom) {
        this.carShowroom = carShowroom;
    }

    @GetMapping("/brand")
    public String getCarBrand(){
        return carShowroom.getiCar().specs();
    }


}
