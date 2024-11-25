package com.ooad.group12.bedstore;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BedstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BedstoreApplication.class, args);
	}



	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("My API")
						.version("1.0")
						.description("API documentation for my application"));
	}

}
