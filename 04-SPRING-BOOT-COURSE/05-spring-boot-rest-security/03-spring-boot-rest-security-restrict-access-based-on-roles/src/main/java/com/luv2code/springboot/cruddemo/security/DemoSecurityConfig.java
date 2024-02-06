package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager (){

        UserDetails nicole = User.builder()
                .username("nicole")
                .password("admin")
                .roles("EMPLOYEE")
                .build();
        UserDetails luis = User.builder()
                .username("luis")
                .password("{noop}12345")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        UserDetails daniel = User.builder()
                .username("dacm")
                .password("{noop}12345")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(nicole, luis, daniel);
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        //USE HTTP BASIC AUTHENTICATION
        http.httpBasic(Customizer.withDefaults());

        //DISABLE CROSS SITE REQUEST FORGERY (CSRF)
        //IN GENERAL, NO REQUIRED FOR STATALES REST APIS, THAT USE POST , PUT, DELETE AND/OR PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();

    }
}
