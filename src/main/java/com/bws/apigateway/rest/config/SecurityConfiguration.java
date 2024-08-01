package com.bws.apigateway.rest.config;

import com.bws.apigateway.auth.JwtAuthenticationFilter;
import com.bws.apigateway.model.Role;
import com.bws.apigateway.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return ((request, response, accessDeniedException) ->
                response.sendRedirect("/access-denied"));

    }


    @SuppressWarnings({"Convert2MethodRef", "LambdaBodyCanBeCodeBlock"})
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

//        httpSecurity.csrf().disable().authorizeHttpRequests().requestMatchers("/notlocked/**").hasRole(Role.ADMIN.toString());

        //TODO burayi bi kontrol et bakalim

        //burada rol kisimlari eklendi hata olusturursa cikartilabilir...

        httpSecurity.csrf(configure -> configure
                        .disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/auth/**" )
                        .permitAll()
                        .requestMatchers("/user/**") //.hasRole("USER")
                        .permitAll()
                        .requestMatchers("/stock/product/add")
                        .authenticated()// MUST HAVE SELLER ROLE
                        .requestMatchers("/stock/category/update")
                        .authenticated()// MUST HAVE SELLER ROLE
                        .requestMatchers("/microservice/dashboard")
                        .authenticated() // MUST HAVE ADMIN ROLE...
                        .requestMatchers("/stock/**")
                        .authenticated()
                        .requestMatchers("/payment/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
}

