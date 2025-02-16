package com.facetime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.facetime.user.User;
import com.facetime.user.UserService;

@SpringBootApplication
public class FacetimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacetimeApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			UserService service) {
		return args -> {
			service.register(User.builder()
					.username("Pat")
					.email("pat@test.com")
					.password("pat")
					.build());

			service.register(User.builder()
					.username("Albert")
					.email("albert@test.com")
					.password("albert")
					.build());

			service.register(User.builder()
					.username("karen")
					.email("karen@test.com")
					.password("karen")
					.build());
		};
	}

}
