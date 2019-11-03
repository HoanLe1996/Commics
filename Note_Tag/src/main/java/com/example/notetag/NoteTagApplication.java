package com.example.notetag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NoteTagApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteTagApplication.class, args);
	}

}
