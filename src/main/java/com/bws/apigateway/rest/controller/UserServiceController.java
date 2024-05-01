package com.bws.apigateway.rest.controller;

import com.bws.apigateway.api.request.AddAddressInfoRequest;
import com.bws.apigateway.api.request.AddBalanceRequest;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.EmailValidatorRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.GetBalanceResponse;
import com.bws.apigateway.api.response.SellerGetResponse;
import com.bws.apigateway.model.constants.PropertyConstants;
import com.bws.apigateway.rest.controller.api.UserRestServiceApi;
import com.bws.apigateway.rest.servicecall.UserServiceCallImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = PropertyConstants.REQUEST_SECURE_SERVICE_USER_CONTROLLER)
@CrossOrigin
@RequiredArgsConstructor

public class UserServiceController implements UserRestServiceApi {

    private final UserServiceCallImpl userServiceCall;

    @Override
    public ResponseEntity<BaseResponse> addBalance(AddBalanceRequest addBalanceRequest, HttpServletRequest request, BindingResult bindingResult) {
        return ResponseEntity.ok(userServiceCall.addBalanceRequest(addBalanceRequest));
    }

    @Override
    public ResponseEntity<GetBalanceResponse> getBalance(BaseRequest baseRequest, HttpServletRequest request, BindingResult bindingResult){
        return ResponseEntity.ok(userServiceCall.getBalanceRequest(baseRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> addAddressInfo(AddAddressInfoRequest addAddressInfoRequest, HttpServletRequest request) {
        return ResponseEntity.ok(userServiceCall.addAddressInfo(addAddressInfoRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> userActivate(EmailValidatorRequest emailValidatorRequest, HttpServletRequest request) {
        return ResponseEntity.ok(userServiceCall.emailValidate(emailValidatorRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> sellerActivate(String sellerid, BaseRequest baseRequest, HttpServletRequest request) {
        return ResponseEntity.ok(userServiceCall.activateSellerByAdmin(sellerid , baseRequest));
    }

    @Override
    public ResponseEntity<SellerGetResponse> notActiveSellers(String sellers, BaseRequest baseRequest, HttpServletRequest request) {
        return ResponseEntity.ok(userServiceCall.getSellers(sellers,baseRequest));
    }


}
