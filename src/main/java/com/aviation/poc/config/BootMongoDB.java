package com.aviation.poc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.aviation.poc.entity.Login;
import com.aviation.poc.repository.LoginRepository;

@Configuration
@EnableAutoConfiguration
@Component
public class BootMongoDB implements CommandLineRunner {

	@Autowired
	private LoginRepository loginRepository;

	public void run(String... args) throws Exception {
		loginRepository.deleteAll();
		System.out.println("Inside Run method");
		Login login = new Login();
		login.setUsername("capgemini");
		login.setPassword("capgemini");
		loginRepository.save(login);
	}

}