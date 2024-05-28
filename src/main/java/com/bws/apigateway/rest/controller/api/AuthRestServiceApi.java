package com.bws.apigateway.rest.controller.api;

import com.bws.apigateway.api.request.*;
import com.bws.apigateway.api.response.AuthUserResponse;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.model.constants.PropertyConstants;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthRestServiceApi {
    @PostMapping(path = PropertyConstants.REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_LOGIN, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AuthUserResponse> authUser (@NonNull @RequestBody AuthUserRequest authUserRequest , HttpServletRequest request, BindingResult bindingResult);

    @PostMapping(path = PropertyConstants.REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> registerUser (@NonNull @RequestBody UserAddRequest userAddRequest , HttpServletRequest request, BindingResult bindingResult);

    @PostMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_AUTH_SERVICE_PASSWORD_CHANGE , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> passwordChange (@NonNull @RequestBody PasswordChangeRequest passwordChangeRequest , HttpServletRequest request);

    @PostMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_AUTH_SERVICE_LOGOUT , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> logoutUser(@RequestBody BaseRequest baseRequest , HttpServletRequest request);

    @PostMapping(path = PropertyConstants.REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_REGISTER_AS_SELLER , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> registerSeller (@NonNull @RequestBody SellerAddRequest sellerAddRequest, HttpServletRequest request);

    @PostMapping(path = PropertyConstants.REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_PASSWORD_FORGET, consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> forgetPassword (@NonNull @RequestBody ForgetPasswordRequest forgetPasswordRequest, HttpServletRequest request);

    @PostMapping(path = PropertyConstants.REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_PASSWORD_CHANGE_WITH_CODE, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> changePwByCode (@NonNull @RequestBody ChangePwByCodeRequest changePwByCodeRequest , HttpServletRequest request);


}
