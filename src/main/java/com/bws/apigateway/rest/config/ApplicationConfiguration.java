package com.bws.apigateway.rest.config;


import com.bws.apigateway.model.constants.Constants;
import com.bws.apigateway.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.AbstractFormWriter;
import org.springframework.cloud.openfeign.support.JsonFormWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableAspectJAutoProxy
@RequiredArgsConstructor
@Slf4j

public class ApplicationConfiguration {

    private final UserRepository userRepository;

    private final ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;

    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        try {
            return userRepository::findByUsername;
        } catch (Exception e) {
            log.warn(UsernameNotFoundException.class.getName());
            throw new UsernameNotFoundException(Constants.USER_NOT_FOUND);
        }
    }

    @Bean
    public AbstractFormWriter jsonFormWriter() {
        return new JsonFormWriter();
    }




}
