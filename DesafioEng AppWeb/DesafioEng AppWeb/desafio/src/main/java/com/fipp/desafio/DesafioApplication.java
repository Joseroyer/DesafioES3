package com.fipp.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fipp.desafio.util.BDSingleton;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		BDSingleton.conectar();
		SpringApplication.run(DesafioApplication.class, args);
	}

}
