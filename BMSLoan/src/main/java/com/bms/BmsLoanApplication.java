package com.bms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BmsLoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmsLoanApplication.class, args);
	}

}
