package com.example.spring.jersey.security.services.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Hello Service REST API using Jersey Annotations
 * 
 * @author Sasikumar Venkatesh
 *
 */
@Component
@Path("/hello")
public class HelloServiceResource {

	private static final Logger LOGGER = LogManager.getLogger();

	@GET
	public String getHello() {
		LOGGER.traceEntry();
		return LOGGER.traceExit("Hello World");
	}

	@GET
	@Path("/secureGet")
	public String secureGet() {
		LOGGER.traceEntry();
		return LOGGER.traceExit("You are accessing this because you have authenticated.");
	}

	@POST
	@Path("/securePost")
	@Consumes(MediaType.TEXT_PLAIN)
	public String securePost(String body) {
		LOGGER.traceEntry(body);
		return LOGGER.traceExit("You are accessing this because you have authenticated. body text = " + body);
	}
}
