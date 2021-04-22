package com.vitorduarte.OrangeTalentsAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OrangeTalentsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrangeTalentsApiApplication.class, args);
	}

}
