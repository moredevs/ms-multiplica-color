package com.multiplica.talent.microservicecolors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 
@SpringBootApplication
public class MicroServiceColorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceColorsApplication.class, args);
	}

}
