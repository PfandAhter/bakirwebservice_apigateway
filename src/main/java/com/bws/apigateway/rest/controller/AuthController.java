package com.bws.apigateway.rest.controller;


import com.bws.apigateway.api.request.AuthUserRequest;
import com.bws.apigateway.api.request.UserAddRequest;
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
@RequestMapping(path = PropertyConstants.REQUEST_NOTLOCKED_AUTHSERVICE)
@Slf4j
@RequiredArgsConstructor
@CrossOrigin

public class AuthController implements AuthRestServiceApi {

    private final AuthServiceCallImpl authServiceCall;

    @Override
    public ResponseEntity<AuthUserResponse> authUser(AuthUserRequest authUserRequest, HttpServletRequest request, BindingResult bindingResult){
        return ResponseEntity.ok(authServiceCall.authUserServiceCall(authUserRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> registerUser(UserAddRequest userAddRequest, HttpServletRequest request, BindingResult bindingResult){
        return ResponseEntity.ok(authServiceCall.userRegister(userAddRequest));
    }
}
