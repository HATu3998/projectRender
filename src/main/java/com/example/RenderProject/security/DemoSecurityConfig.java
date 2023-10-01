package com.example.RenderProject.security;

import java.io.ObjectInputFilter.Config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailManager() {
		UserDetails join =User.builder()
				.username("join")
				.password("{noop}test123")
				.roles("EMPLOYY")
				.build();
		UserDetails mary =User.builder()
				.username("mary")
				.password("{noop}test123")
				.roles("EMPLOYY","ADMIN")
				.build();
		return new InMemoryUserDetailsManager(join,mary);
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(configurer -> 
		configurer.anyRequest().authenticated()
		).formLogin(form -> 
		form.loginPage("/showLoginPage")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll());
		return http.build();
	}

}
