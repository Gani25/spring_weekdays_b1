package com.sprk.api_demo.showroom;

import com.sprk.api_demo.cars.ICar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CarShowroom {

    private final ICar iCar ;

    @Autowired
    public CarShowroom(@Qualifier("tataCar") ICar iCar) {
        this.iCar = iCar;
    }

    public ICar getiCar() {
        return iCar;
    }
}
