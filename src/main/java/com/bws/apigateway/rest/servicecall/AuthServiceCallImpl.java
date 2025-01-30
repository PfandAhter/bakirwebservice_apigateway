package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.client.AuthServiceClient;
import com.bws.apigateway.api.request.*;
import com.bws.apigateway.api.response.AuthUserResponse;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.rest.servicecall.interfaces.IAuthServiceCall;
import com.bws.apigateway.rest.util.ServiceNameProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class AuthServiceCallImpl implements IAuthServiceCall, ServiceNameProvider {

    private final AuthServiceClient authServiceClient;

    @Override
    public String getServiceName() {
        return "auth-service";
    }

    @Override
    public AuthUserResponse authServiceLoginCall(AuthUserRequest request){
        return authServiceClient.loginRequest(request);
    }

    @Override
    public BaseResponse authServiceRegisterCall(UserAddRequest request){
        return authServiceClient.registerRequest(request);
    }

    @Override
    public BaseResponse changePasswordCall(PasswordChangeRequest request){
        return authServiceClient.changePassword(request);
    }

    @Override
    public BaseResponse logoutUser (BaseRequest request){
        return authServiceClient.logoutUser(request);
    }

    @Override
    public BaseResponse authServiceRegisterSeller (SellerAddRequest request){
        return authServiceClient.registerSellerRequest(request);
    }

    @Override
    public BaseResponse forgetPassword (ForgetPasswordRequest request){
        return authServiceClient.forgetPassword(request);
    }

    @Override
    public BaseResponse changePwByCode (ChangePwByCodeRequest request){
        return authServiceClient.changePwByCode(request);
    }

}
