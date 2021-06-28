package com.accelerator.spring.automationaccelerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class AutomationAcceleratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomationAcceleratorApplication.class, args);
	}

}
