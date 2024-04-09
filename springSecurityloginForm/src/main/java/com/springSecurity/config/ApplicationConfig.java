package com.springSecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration 
@EnableWebSecurity
public class ApplicationConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .requestMatchers("/public/**").permitAll() // Allow access to public resources
                .anyRequest().authenticated() // Require authentication for other requests
            .and()
            .formLogin() // Enable form login
                .loginPage("/login") // Specify custom login page
                .permitAll() // Allow access to login page
            .and()
            .logout() // Enable logout
                .logoutSuccessUrl("/login?logout") // Specify logout success URL
                .permitAll(); // Allow access to logout URL
    }
}
