package com.br.tracing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PocTracingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocTracingApplication.class, args);
	}

}
