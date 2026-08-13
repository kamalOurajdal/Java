package com.example.demo.security;

import org.springframework.http.HttpStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
            User.withUsername("user1").password("{noop}1234").roles("USER").build(),
            User.withUsername("admin").password("{noop}1234").roles("ADMIN").build(),
            User.withUsername("user2").password("{noop}1234").roles("ADMIN", "USER").build()
        );
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .formLogin(form -> form.defaultSuccessUrl("/", true))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/403.html").permitAll()
                .anyRequest().authenticated()
            )
            .exceptionHandling(exceptionHandling -> exceptionHandling
                .accessDeniedHandler((request, response, accessDeniedException) -> {
                    response.setStatus(HttpStatus.FORBIDDEN.value());
                    request.getRequestDispatcher("/403.html").forward(request, response);
                })
            );
            

        return httpSecurity.build();
    }
}
