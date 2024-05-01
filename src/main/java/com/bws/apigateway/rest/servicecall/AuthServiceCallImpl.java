package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.client.AuthServiceClient;
import com.bws.apigateway.api.request.*;
import com.bws.apigateway.api.response.AuthUserResponse;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.model.entity.LogApiGateway;
import com.bws.apigateway.repository.LogApiGatewayRepository;
import com.bws.apigateway.rest.servicecall.interfaces.IAuthServiceCall;
import com.bws.apigateway.rest.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j

public class AuthServiceCallImpl implements IAuthServiceCall {

    private final LogApiGatewayRepository logApiGatewayRepository;

    private final AuthServiceClient authServiceClient;

    @Override
    public AuthUserResponse authServiceLoginCall(AuthUserRequest request){
        logInDataBase(AuthUserRequest.class.getName(),AuthUserResponse.class.getName());
        return authServiceClient.loginRequest(request);
    }

    @Override
    public BaseResponse authServiceRegisterCall(UserAddRequest request){
        logInDataBase(UserAddRequest.class.getName(),BaseResponse.class.getName());
        return authServiceClient.registerRequest(request);
    }

    public BaseResponse changePasswordCall(PasswordChangeRequest request){
        //log to database
        return authServiceClient.changePassword(request);
    }

    public BaseResponse logoutUser (BaseRequest request){
        //log to database
        return authServiceClient.logoutUser(request);
    }

    public BaseResponse authServiceRegisterSeller (SellerAddRequest request){
        //log to database
        return authServiceClient.registerSellerRequest(request);
    }


    private void logInDataBase(String requestType, String responseType){
        logApiGatewayRepository.save(LogApiGateway.builder().fetchedMicroservice(
                "AuthService")
                .logId(Util.generateCode())
                .requestType(requestType)
                .error_code(0000L)
                .successfully(1)
                .responseType(responseType).build());
    }

}
