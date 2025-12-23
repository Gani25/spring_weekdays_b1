package com.sprk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sprk.cars.BMW;
import com.sprk.cars.Kia;
import com.sprk.cars.Tata;
import com.sprk.showroom.CarShowroom;

@Configuration
public class SpringConfig {

	// Objects (Bean)
	@Bean
	public Tata getTata() {
		return new Tata();
	}

	@Bean
	public Kia getKia() {
		return new Kia();
	}

	@Bean
	public BMW getBmw() {
		return new BMW();
	}

	@Bean(name = "showRoomBean")
	public CarShowroom carShowroom() {
		// COnstructor Injection
		// return new CarShowroom(getTata());
		
		// Setter Inj
		CarShowroom showroom = new CarShowroom();
		showroom.setICar(getKia());
		
		return showroom;
	}

}
