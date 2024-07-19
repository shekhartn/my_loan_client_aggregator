package com.loan.aggregator.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LoanAggregatorClientApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LoanAggregatorClientApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(LoanAggregatorClientApplication.class, args);
	}

}
