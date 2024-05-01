package com.bws.apigateway.rest.controller.api;

import com.bws.apigateway.api.request.AddAddressInfoRequest;
import com.bws.apigateway.api.request.AddBalanceRequest;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.EmailValidatorRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.GetBalanceResponse;
import com.bws.apigateway.api.response.SellerGetResponse;
import com.bws.apigateway.model.constants.PropertyConstants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserRestServiceApi {

    @PostMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_USER_SERVICE_BALANCE_ADD,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> addBalance (@Valid @RequestBody AddBalanceRequest addBalanceRequest, HttpServletRequest request, BindingResult bindingResult);

    @GetMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_USER_SERVICE_BALANCE_GET)
    ResponseEntity<GetBalanceResponse> getBalance (@Valid BaseRequest baseRequest, HttpServletRequest request, BindingResult bindingResult);

    @PostMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_USER_SERVICE_ADD_USER_ADDRESS_INFO , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> addAddressInfo (@Valid @RequestBody AddAddressInfoRequest addAddressInfoRequest, HttpServletRequest request);

    @PostMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_USER_SERVICE_USER_ACTIVATE , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> userActivate (@Valid @RequestBody EmailValidatorRequest emailValidatorRequest , HttpServletRequest request);

    @GetMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_USER_SERVICE_SELLER_ACTIVATE_BY_ADMIN)
    ResponseEntity<BaseResponse> sellerActivate (@RequestParam("sellerid") String sellerid ,BaseRequest baseRequest , HttpServletRequest request);

    @GetMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_USER_SERVICE_SELLER_NOT_ACTIVATED)
    ResponseEntity<SellerGetResponse> notActiveSellers (@RequestParam("sellers") String sellers , BaseRequest baseRequest , HttpServletRequest request);
}
