package com.youssef.server_ui_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ServerUiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerUiDemoApplication.class, args);
	}

}
