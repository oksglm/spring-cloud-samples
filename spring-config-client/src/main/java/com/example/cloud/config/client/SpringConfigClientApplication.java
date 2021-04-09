package com.example.cloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigClientApplication.class, args);
	}

}

@RefreshScope
@RestController
class MessageRestController {

	@Value("${default.msg:Config Server is not working. Please check...}")
	private String message;

	@RequestMapping("/message")
	String getMessage() {
		return this.message;
	}

}
