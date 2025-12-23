package com.sprk.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sprk.cars.BMW;
import com.sprk.cars.ICar;
import com.sprk.cars.Kia;
import com.sprk.cars.Tata;
import com.sprk.showroom.CarShowroom;

public class MainClassXML1 {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
		
//		CarShowroom carShowroom = (CarShowroom) context.getBean("showRoomBean");
		CarShowroom carShowroom = context.getBean("showRoomBean", CarShowroom.class);
		
		carShowroom.getICar().showSpec();
	}

}
