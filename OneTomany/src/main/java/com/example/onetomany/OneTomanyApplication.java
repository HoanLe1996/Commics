package com.example.onetomany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OneTomanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneTomanyApplication.class, args);
	}

}
