package com.example.RenderProject.security;

import java.io.ObjectInputFilter.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.annotation.security.PermitAll;

@Configuration
public class DemoSecurityConfig {

//	@Bean
//	public InMemoryUserDetailsManager userDetailManager() {
//		UserDetails join =User.builder()
//				.username("join")
//				.password("{noop}test123")
//				.roles("EMPLOYEE")
//				.build();
//		UserDetails mary =User.builder()
//				.username("mary")
//				.password("{noop}test123")
//				.roles("EMPLOYEE","ADMIN")
//				.build();
//		return new InMemoryUserDetailsManager(join,mary);
//	}
	
	 @Bean
	 public UserDetailsManager userDetailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
		 
	 }
	 
	 
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(configurer -> 
		configurer
		.requestMatchers("/").hasAnyRole("EMPLOYEE","ADMIN")
		.requestMatchers("leaders").hasRole("ADMIN")
		.anyRequest().authenticated()
		).formLogin(form -> 
		form.loginPage("/showLoginPage")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll())
		.logout(logout -> logout.permitAll())
		.exceptionHandling(configurer -> configurer.accessDeniedPage("/errorLogin"));
		return http.build();
	}

}
