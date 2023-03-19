package com.dependency.injection.springinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.dependency.injection",
		"com.dependency.util"})
public class SpringInjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringInjectionApplication.class, args);
	}

}
