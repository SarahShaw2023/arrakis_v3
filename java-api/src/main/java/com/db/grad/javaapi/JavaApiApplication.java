package com.db.grad.javaapi;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.service.BondsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaApiApplication.class, args);
	}
}