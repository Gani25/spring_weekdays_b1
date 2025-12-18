package com.sprk.showroom;

import com.sprk.cars.ICar;


public class CarShowroom {
	
	// brand
//	private Kia kia;
	
	private ICar iCar;

	public CarShowroom(ICar iCar) {
		System.out.println("Showroom created with branded cars of "+iCar.getClass().getName());
		this.iCar = iCar;
	}

	public ICar getICar() {
		return iCar;
	}

	public void setICar(ICar iCar) {
		this.iCar = iCar;
	}
	
	
	
	
	
	

}
