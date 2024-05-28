package com.bws.apigateway.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ChangePwByCodeRequest {
    //TODO BURANIN DEVAMINI GETIR...
    private String email;
    private String emailCode;
    private String newPassword;
    private String newPasswordAgain;

}
