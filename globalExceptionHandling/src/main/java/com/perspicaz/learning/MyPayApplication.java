package com.perspicaz.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MyPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPayApplication.class, args);
	}

}
