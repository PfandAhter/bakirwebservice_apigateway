package com.bws.apigateway.rest.servicecall.interfaces;

import com.bws.apigateway.api.request.AuthUserRequest;
import com.bws.apigateway.api.request.UserAddRequest;
import com.bws.apigateway.api.response.AuthUserResponse;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.exceptions.ServiceUnavailableException;

public interface IAuthServiceCall {

    AuthUserResponse authUserServiceCall (AuthUserRequest request) ;

    BaseResponse userRegister (UserAddRequest request);


}
