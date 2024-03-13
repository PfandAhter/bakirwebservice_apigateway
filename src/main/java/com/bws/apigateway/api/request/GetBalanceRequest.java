package com.bws.apigateway.api.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetBalanceRequest extends BaseRequest{
    private String username;
}
