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
import com.bws.apigateway.rest.servicecall.interfaces.IUserServiceCall;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(path = PropertyConstants.REQUEST_SECURE_SERVICE_USER_CONTROLLER)
@CrossOrigin
@RequiredArgsConstructor

public class UserServiceController implements UserRestServiceApi {

    private final IUserServiceCall userServiceCall;

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
    public ResponseEntity<BaseResponse> sellerActivate(String sellerId, BaseRequest baseRequest, HttpServletRequest request) {
        return ResponseEntity.ok(userServiceCall.activateSellerByAdmin(sellerId , baseRequest));
    }

    @Override
    public ResponseEntity<SellerGetResponse> notActiveSellers(String sellers, BaseRequest baseRequest, HttpServletRequest request) {
        return ResponseEntity.ok(userServiceCall.getSellers(sellers,baseRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> addPhoto(MultipartFile image, BaseRequest baseRequest, HttpServletRequest request) {
        return ResponseEntity.ok(userServiceCall.addPhoto(image,baseRequest));
    }

    @Override
    public ResponseEntity<byte[]> getPhoto(BaseRequest baseRequest, HttpServletRequest request) {
        return ResponseEntity.ok(userServiceCall.getPhoto(baseRequest));
    }


}
