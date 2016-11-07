package com.aviation.poc;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.aviation.poc.config.AviationLoginFilter;

@SpringBootApplication
public class AviationUiApplication extends SpringBootServletInitializer {

	@Value("${services.auth}")
	private String authService;

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new AviationLoginFilter());
		registrationBean.setInitParameters(Collections.singletonMap("services.auth", authService));
		registrationBean.addUrlPatterns("/");

		return registrationBean;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AviationUiApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AviationUiApplication.class, args);
	}
}
