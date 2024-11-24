package com.spring.cards;

import com.spring.cards.entity.AccountContactInfoDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
@EnableConfigurationProperties(value = AccountContactInfoDTO.class)

public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
