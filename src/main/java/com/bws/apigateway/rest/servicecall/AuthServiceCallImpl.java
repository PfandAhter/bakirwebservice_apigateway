package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.client.AuthServiceClient;
import com.bws.apigateway.api.request.AuthUserRequest;
import com.bws.apigateway.api.request.UserAddRequest;
import com.bws.apigateway.api.response.AuthUserResponse;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.model.entity.LogApiGateway;
import com.bws.apigateway.repository.LogApiGatewayRepository;
import com.bws.apigateway.rest.servicecall.interfaces.IAuthServiceCall;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.bws.apigateway.model.constants.PropertyConstants.REST_TEMPLATE_REQUEST_MICROSERVICE_AUTH_SERVICE_AUTH_LOGIN;
import static com.bws.apigateway.model.constants.PropertyConstants.REST_TEMPLATE_REQUEST_MICROSERVICE_AUTH_SERVICE_AUTH_REGISTER;

@Service
@RequiredArgsConstructor
@Slf4j

public class AuthServiceCallImpl implements IAuthServiceCall {

    private final RestTemplate restTemplate;
    private final LogApiGatewayRepository logApiGatewayRepository;

    private final AuthServiceClient authServiceClient;

    @Value(REST_TEMPLATE_REQUEST_MICROSERVICE_AUTH_SERVICE_AUTH_LOGIN)
    private String authUserPath;

    @Override
    public AuthUserResponse authUserServiceCall(AuthUserRequest request){
        logInDataBase(request.getClass().getName(),AuthUserResponse.class.getName());
        return authServiceClient.loginRequest(request);
//        restTemplate.postForObject(authUserPath, request, AuthUserResponse.class);
    }

    @Value(REST_TEMPLATE_REQUEST_MICROSERVICE_AUTH_SERVICE_AUTH_REGISTER)
    private String registerUserPath;

    @Override
    public BaseResponse userRegister(UserAddRequest request){
        logInDataBase(request.getClass().getName(),BaseResponse.class.getName());
        return authServiceClient.registerReqeust(request);
//        return restTemplate.postForObject(registerUserPath, request, BaseResponse.class);

    }

    private void logInDataBase(String baseRequest, String responseType){
        logApiGatewayRepository.save(LogApiGateway.builder().fetchedMicroservice(
                "AuthService")
                .requestType(baseRequest.substring(31,baseRequest.length()).toString())
                .error_code(0000L)
                .successfully(1)
                .responseType(responseType).build());
    }

}
