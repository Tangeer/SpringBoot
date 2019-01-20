package com.longrise.springboot;

import com.longrise.springboot.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		UserService us = (UserService) context.getBean("userServiceImpl");
		String hi = us.getUser("springboot-java");
		System.out.println(hi);
	}

}

