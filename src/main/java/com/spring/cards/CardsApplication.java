package com.spring.cards;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@OpenAPIDefinition(info = @Info(
		title = "Cards microservice REST API Documentation",
		description = "EazyBank Cards microservice REST API Documentation",
		version = "v1",
		contact = @Contact(
				name = "Aryan",
				email = "aryanjidnal103@gmail.com"
		)
),
		externalDocs = @ExternalDocumentation(
				description = "Cards microservice REST API Documentation"))
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
