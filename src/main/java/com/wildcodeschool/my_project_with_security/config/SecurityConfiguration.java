package com.wildcodeschool.my_project_with_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    return http

        .authorizeHttpRequests(auth -> {
          auth.requestMatchers("/").permitAll();
          auth.requestMatchers("/avengers/assemble").hasRole("CHAMPION");
          auth.requestMatchers("/secret-bases").hasRole("DIRECTOR")
              .anyRequest().authenticated();
        })
        .formLogin(Customizer.withDefaults())

        .build();
  }

  @Bean
  public InMemoryUserDetailsManager userDetailsManager() {
    UserDetails champion = User.withDefaultPasswordEncoder()
        .username("Steve")
        .password("motdepasse")
        .roles("CHAMPION")
        .build();
    UserDetails director = User.withDefaultPasswordEncoder()
        .username("Nick")
        .password("flerken")
        .roles("DIRECTOR")
        .build();
    return new InMemoryUserDetailsManager(champion, director);

  }

}
