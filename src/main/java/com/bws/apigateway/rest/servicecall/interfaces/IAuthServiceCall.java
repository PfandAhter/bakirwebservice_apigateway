package com.bws.apigateway.rest.servicecall.interfaces;

import com.bws.apigateway.api.request.*;
import com.bws.apigateway.api.response.AuthUserResponse;
import com.bws.apigateway.api.response.BaseResponse;

public interface IAuthServiceCall {

    AuthUserResponse authServiceLoginCall(AuthUserRequest request) ;

    BaseResponse authServiceRegisterCall(UserAddRequest request);

    BaseResponse changePasswordCall(PasswordChangeRequest request);

    BaseResponse logoutUser (BaseRequest request);

    BaseResponse authServiceRegisterSeller (SellerAddRequest request);

    BaseResponse forgetPassword (ForgetPasswordRequest request);

    BaseResponse changePwByCode (ChangePwByCodeRequest request);


}
