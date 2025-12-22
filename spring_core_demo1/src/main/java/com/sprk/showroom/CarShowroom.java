package com.sprk.showroom;

import com.sprk.cars.ICar;


public class CarShowroom {
	
	// brand
//	private Kia kia;
	
	// property
	private ICar iCar;
	
	public CarShowroom() {
		System.out.println("Showroom created with default constructor");
	}

	public CarShowroom(ICar iCar) {
		System.out.println("Showroom created with branded cars of "+iCar.getClass().getName());
		this.iCar = iCar;
	}

	public ICar getICar() {
		return iCar;
	}

	public void setICar(ICar iCar) {
		System.out.println("Showroom created with branded cars of "+iCar.getClass().getName()+". Car Injected from Setter");
		this.iCar = iCar;
	}
	
	
	
	
	
	

}
