package com.sprk.main;

import com.sprk.cars.BMW;
import com.sprk.cars.ICar;
import com.sprk.cars.Kia;
import com.sprk.cars.Tata;
import com.sprk.showroom.CarShowroom;

public class MainClass {
	
	public static void main(String[] args) {
		
//		Tata tata = new Tata(); // obj of tata car
		
		ICar car = new Kia();
		CarShowroom carShowroom = new CarShowroom(car);
		
		carShowroom.getICar().showSpec();
	}

}
