package com.sprk.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sprk.cars.BMW;
import com.sprk.cars.ICar;
import com.sprk.cars.Kia;
import com.sprk.cars.Tata;
import com.sprk.config.SpringConfig;
import com.sprk.showroom.CarShowroom;

public class MainClassAnnotationBased {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);		
//		CarShowroom carShowroom = (CarShowroom) context.getBean("showRoomBean");
		CarShowroom carShowroom = context.getBean("showRoomBean", CarShowroom.class);
		
		carShowroom.getICar().showSpec();
	}

}
