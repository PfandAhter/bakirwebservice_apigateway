package com.bws.apigateway.rest.controller.api;

import com.bws.apigateway.api.request.AuthUserRequest;
import com.bws.apigateway.api.request.UserAddRequest;
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
    @PostMapping(path = PropertyConstants.REQUEST_AUTHUSER , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AuthUserResponse> authUser (@NonNull @RequestBody AuthUserRequest authUserRequest , HttpServletRequest request, BindingResult bindingResult);

    @PostMapping(path = PropertyConstants.REQUEST_REGISTERUSER , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> registerUser (@NonNull @RequestBody UserAddRequest userAddRequest , HttpServletRequest request, BindingResult bindingResult);

}
