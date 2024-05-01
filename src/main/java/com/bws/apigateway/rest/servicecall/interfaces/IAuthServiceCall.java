package com.bws.apigateway.rest.servicecall.interfaces;

import com.bws.apigateway.api.request.AuthUserRequest;
import com.bws.apigateway.api.request.UserAddRequest;
import com.bws.apigateway.api.response.AuthUserResponse;
import com.bws.apigateway.api.response.BaseResponse;

public interface IAuthServiceCall {

    AuthUserResponse authServiceLoginCall(AuthUserRequest request) ;

    BaseResponse authServiceRegisterCall(UserAddRequest request);


}
