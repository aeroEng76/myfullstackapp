package com.github.aeroEng76.mysbapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class MySbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySbApplication.class, args);
	}

}
