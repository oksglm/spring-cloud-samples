package com.example.cloud.config.server;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class SSLConfig {

	@Autowired
	private Environment env;

	@PostConstruct
	private void configureSSL() {
		System.setProperty("https.protocols", "TLSv1.2");
		System.setProperty("javax.net.ssl.trustStore", env.getProperty("trust.store"));
		System.setProperty("javax.net.ssl.trustStorePassword", env.getProperty("trust.store.password"));
	}

}
