package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.client.AuthServiceClient;
import com.bws.apigateway.api.request.*;
import com.bws.apigateway.api.response.AuthUserResponse;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.model.entity.LogApiGateway;
import com.bws.apigateway.repository.LogApiGatewayRepository;
import com.bws.apigateway.rest.servicecall.interfaces.IAuthServiceCall;
import com.bws.apigateway.rest.util.Util;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j

public class AuthServiceCallImpl implements IAuthServiceCall {

    private final LogApiGatewayRepository logApiGatewayRepository;

    private final AuthServiceClient authServiceClient;

    private static final String serviceName = "auth-service";

    @Override
    @Transactional
    public AuthUserResponse authServiceLoginCall(AuthUserRequest request){
        logInDataBase(AuthUserRequest.class.getName(),AuthUserResponse.class.getName());
        return authServiceClient.loginRequest(request);
    }

    @Override
    @Transactional
    public BaseResponse authServiceRegisterCall(UserAddRequest request){
        logInDataBase(UserAddRequest.class.getName(),BaseResponse.class.getName());
        return authServiceClient.registerRequest(request);
    }

    @Override
    @Transactional
    public BaseResponse changePasswordCall(PasswordChangeRequest request){
        logInDataBase(PasswordChangeRequest.class.getName(),BaseResponse.class.getName());
        return authServiceClient.changePassword(request);
    }

    @Override
    @Transactional
    public BaseResponse logoutUser (BaseRequest request){
        logInDataBase(BaseRequest.class.getName(),BaseResponse.class.getName());
        return authServiceClient.logoutUser(request);
    }

    @Override
    @Transactional
    public BaseResponse authServiceRegisterSeller (SellerAddRequest request){
        logInDataBase(SellerAddRequest.class.getName(),BaseResponse.class.getName());
        return authServiceClient.registerSellerRequest(request);
    }

    @Override
    @Transactional
    public BaseResponse forgetPassword (ForgetPasswordRequest request){
        logInDataBase(ForgetPasswordRequest.class.getName(),BaseResponse.class.getName());
        return authServiceClient.forgetPassword(request);
    }

    @Override
    @Transactional
    public BaseResponse changePwByCode (ChangePwByCodeRequest request){
        logInDataBase(ChangePwByCodeRequest.class.getName(),BaseResponse.class.getName());
        return authServiceClient.changePwByCode(request);
    }


    @Override
    @Transactional
    public void logInDataBase(String requestType, String responseType){
        logApiGatewayRepository.save(LogApiGateway.builder().fetchedMicroservice(
                 serviceName)
                .logId(Util.generateCode())
                .requestType(requestType)
                .error_code(5000L)
                .successfully(1)
                .responseType(responseType).build());
    }

}
