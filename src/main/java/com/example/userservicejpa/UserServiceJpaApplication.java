package com.example.userservicejpa;

import com.example.userservicejpa.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class UserServiceJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceJpaApplication.class, args);
	}

}
