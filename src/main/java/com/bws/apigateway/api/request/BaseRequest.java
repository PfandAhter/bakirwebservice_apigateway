package com.bws.apigateway.api.request;

import com.bws.apigateway.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseRequest {

    //TODO Requestlerin iclerine anotasyonlar ile on kontrol ekle...

    @JsonIgnore
    private LocalDateTime time = LocalDateTime.now();

    private String token;

//    private Role role;

//    private String servicePassCode;
}