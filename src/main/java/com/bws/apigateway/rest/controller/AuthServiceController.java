package com.bws.apigateway.rest.controller;


import com.bws.apigateway.api.request.*;
import com.bws.apigateway.api.response.AuthUserResponse;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.model.constants.PropertyConstants;
import com.bws.apigateway.rest.controller.api.AuthRestServiceApi;
import com.bws.apigateway.rest.servicecall.AuthServiceCallImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = PropertyConstants.REQUEST_NOT_SECURE_SERVICE_AUTH_CONTROLLER)
@Slf4j
@RequiredArgsConstructor
@CrossOrigin

public class AuthServiceController implements AuthRestServiceApi {

    private final AuthServiceCallImpl authServiceCall;

    @Override
    public ResponseEntity<AuthUserResponse> authUser(AuthUserRequest authUserRequest, HttpServletRequest request, BindingResult bindingResult){
        return ResponseEntity.ok(authServiceCall.authServiceLoginCall(authUserRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> registerUser(UserAddRequest userAddRequest, HttpServletRequest request, BindingResult bindingResult){
        return ResponseEntity.ok(authServiceCall.authServiceRegisterCall(userAddRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> passwordChange(PasswordChangeRequest passwordChangeRequest, HttpServletRequest request) {
        return ResponseEntity.ok(authServiceCall.changePasswordCall(passwordChangeRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> logoutUser(BaseRequest baseRequest, HttpServletRequest request) {
        return ResponseEntity.ok(authServiceCall.logoutUser(baseRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> registerSeller(SellerAddRequest sellerAddRequest, HttpServletRequest request) {
        return ResponseEntity.ok(authServiceCall.authServiceRegisterSeller(sellerAddRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> forgetPassword(ForgetPasswordRequest forgetPasswordRequest, HttpServletRequest request) {
        return ResponseEntity.ok(authServiceCall.forgetPassword(forgetPasswordRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> changePwByCode(ChangePwByCodeRequest changePwByCodeRequest, HttpServletRequest request) {
        return ResponseEntity.ok(authServiceCall.changePwByCode(changePwByCodeRequest));
    }


}
