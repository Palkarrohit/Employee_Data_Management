package com.example.SprinBooot_JPA_demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ActuatorSecurityConfig {
	

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	        http
	            .csrf(csrf -> csrf.disable())
	            .authorizeHttpRequests(auth -> auth

	                // ✅ Allow actuator only for ADMIN
	                .requestMatchers("/admin/actuator/**").hasRole("ADMIN")

	                // ✅ Allow other APIs normally
	                .anyRequest().permitAll()
	            )
	            .httpBasic(httpBasic -> {}); // simple auth

	        return http.build();
	    }
	}

