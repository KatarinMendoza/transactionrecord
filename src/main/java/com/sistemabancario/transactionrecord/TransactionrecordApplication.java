package com.sistemabancario.transactionrecord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class TransactionrecordApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionrecordApplication.class, args);
	}

}
