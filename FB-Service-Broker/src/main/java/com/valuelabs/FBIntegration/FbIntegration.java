package com.valuelabs.FBIntegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class FbIntegration {
	public static void main(String[] args) {
		SpringApplication.run(FbIntegration.class, args);
	}
}
