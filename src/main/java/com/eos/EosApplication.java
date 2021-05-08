package com.eos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class EosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EosApplication.class, args);
	}

}
