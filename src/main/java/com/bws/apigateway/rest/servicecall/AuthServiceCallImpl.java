package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.request.AuthUserRequest;
import com.bws.apigateway.api.request.UserAddRequest;
import com.bws.apigateway.api.response.AuthUserResponse;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.model.constants.PropertyConstants;
import com.bws.apigateway.rest.servicecall.interfaces.IAuthServiceCall;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j

public class AuthServiceCallImpl implements IAuthServiceCall {

    private final RestTemplate restTemplate;

    @Override
    public AuthUserResponse authUserServiceCall(AuthUserRequest request){

        System.out.println(PropertyConstants.REST_TEMPLATE_REQUEST_MICROSERVICE_AUTH_SERVICE_AUTH_LOGIN);
        return restTemplate.postForObject( PropertyConstants.REST_TEMPLATE_REQUEST_MICROSERVICE_AUTH_SERVICE_AUTH_LOGIN, request, AuthUserResponse.class);

    }

    @Override
    public BaseResponse userRegister(UserAddRequest request){
        return restTemplate.postForObject("http://localhost:8081/auth/register", request, BaseResponse.class);

    }

}
