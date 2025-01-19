package com.example.nob2v2;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
@EnableCaching
public class Nob2v2Application {

	public static void main(String[] args) {


		System.out.println("Hello !");
		SpringApplication.run(Nob2v2Application.class, args);
	}



}
