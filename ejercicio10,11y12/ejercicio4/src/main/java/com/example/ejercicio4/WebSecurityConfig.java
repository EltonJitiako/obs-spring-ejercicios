package com.example.ejercicio4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

            http.authorizeHttpRequests()
                    .requestMatchers("/html").permitAll()
                    .requestMatchers("/api/laptops").hasRole("ADMIN")
                    .and()
                    .formLogin()
                    .and()
                    .httpBasic();

            return http.build();

        }

        @Bean

        public InMemoryUserDetailsManager userDetailsService(){

            UserDetails user = User.withDefaultPasswordEncoder().username("user").password("1234").roles("USER").build();

            UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("1234").roles("ADMIN").build();

            return new InMemoryUserDetailsManager(user, admin);

        }

    }