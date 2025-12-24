package com.sprk.api_demo.showroom;

import com.sprk.api_demo.cars.ICar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarShowroom2 {

    private final List<ICar> iCarList ;

    @Autowired
    public CarShowroom2(List<ICar> iCarList) {
        this.iCarList = iCarList;
    }

    public List<ICar> getiCar() {

        return iCarList;
    }
}
