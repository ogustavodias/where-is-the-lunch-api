package com.ogustavodias.lunch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LunchApplication {

	public static void main(String[] args) {
		SpringApplication.run(LunchApplication.class, args);
	}

}
