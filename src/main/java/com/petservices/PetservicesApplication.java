package com.petservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PetservicesApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(PetservicesApplication.class, args);
		MainEjecutar mainEjecutar = context.getBean(MainEjecutar.class);
		mainEjecutar.ejecutar();
	}

}
