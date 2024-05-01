package com.bws.apigateway.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmailValidatorRequest {
    private String username;
    private String emailValidatorCode;
}
