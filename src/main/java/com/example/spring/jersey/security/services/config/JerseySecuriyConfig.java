package com.example.spring.jersey.security.services.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;

@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JerseySecuriyConfig extends WebSecurityConfigurerAdapter {

	@Value(value = "${auth0.apiAudience}")
	private String apiAudience;
	@Value(value = "${auth0.issuer}")
	private String issuer;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		JwtWebSecurityConfigurer.forRS256(apiAudience, issuer).configure(http).cors().and().csrf().disable()
				.authorizeRequests().antMatchers(HttpMethod.GET, "/hello/secureGet").hasAuthority("authorize:get")
				.antMatchers(HttpMethod.POST, "/hello/securePost").hasAuthority("authorize:post")
				.antMatchers("/hello/**").permitAll();
	}

}
