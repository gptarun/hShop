package com.hsoft.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HSoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(HSoftApplication.class, args);
	}

}
