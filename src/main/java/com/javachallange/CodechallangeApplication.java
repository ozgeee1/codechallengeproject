package com.javachallange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CodechallangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodechallangeApplication.class, args);
	}

}
