package com.clouderwok.vts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.clouderwok.vts.listener.InitListener;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(Application.class);
		springApplication.addListeners(new InitListener());
		springApplication.run(args);
	}
	
}
