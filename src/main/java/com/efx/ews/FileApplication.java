package com.efx.ews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FileApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FileApplication.class, args);
	}



}
