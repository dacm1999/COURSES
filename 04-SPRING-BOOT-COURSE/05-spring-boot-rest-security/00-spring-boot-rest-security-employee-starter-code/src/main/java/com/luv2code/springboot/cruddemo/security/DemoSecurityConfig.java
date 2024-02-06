package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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
}
