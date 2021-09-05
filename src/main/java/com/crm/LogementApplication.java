package com.crm;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//import com.crm.model.Logement;
//import com.crm.repository.LogementRepository;

@SpringBootApplication


@ComponentScan("com.crm")
@EntityScan("com.crm")
@EnableJpaRepositories("com.crm")


public class LogementApplication {
//@Autowired
//LogementRepository lr;
	public static void main(String[] args) {
		SpringApplication.run(LogementApplication.class, args);
	}
//	@SuppressWarnings("resource")
//	@Bean
// public CommandLineRunner console() {
//		return args -> {
//		System.out.println("Start*****\n\n");
//		Logement lg= new Logement("Test",1.9);
//		lr.save(lg);
//		};
//		}

}
