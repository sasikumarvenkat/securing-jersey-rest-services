package com.example.spring.jersey.security.services.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.example.spring.jersey.security.services.api.HelloServiceResource;

@Configuration
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		this.register(HelloServiceResource.class);
	}
}
