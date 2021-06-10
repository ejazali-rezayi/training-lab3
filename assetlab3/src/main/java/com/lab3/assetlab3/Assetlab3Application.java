package com.lab3.assetlab3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.lab3.assetlab3")
public class Assetlab3Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Assetlab3Application.class, args);
	}

}
