package com.urbanisation_si.processus_contrat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.urbanisation_si.processus_contrat")
public class ProcessusContratApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessusContratApplication.class, args);
	}

}
