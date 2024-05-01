package com.bws.apigateway.rest.controller.api;

import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.AddItemRequest;
import com.bws.apigateway.api.request.DeleteOrderByProductCodeRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.BuyItemsInCartResponse;
import com.bws.apigateway.api.response.GetProductDetailsResponse;
import com.bws.apigateway.api.response.QueryTrackingNumberResponse;
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

public interface PaymentRestServiceApi {

    @PostMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_PAYMENT_SERVICE_ORDER_LIST_ADD_BY_PRODUCT_CODE, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> createOrder(@Valid @RequestBody AddItemRequest buyProductWithProductCodeRequest, HttpServletRequest request, BindingResult bindingResult);

    @PostMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_PAYMENT_SERVICE_ORDER_LIST_DELETE_BY_PRODUCT_CODE,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> deleteOrderByProductCode (@Valid @RequestBody DeleteOrderByProductCodeRequest deleteOrderByProductCodeRequest , HttpServletRequest request , BindingResult bindingResult);

    @GetMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_PAYMENT_SERVICE_ORDER_LIST_GET)
    ResponseEntity<GetProductDetailsResponse> getOrderList (BaseRequest baseRequest , HttpServletRequest request);

    @GetMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_PAYMENT_SERVICE_ORDER_LIST_BUY)
    ResponseEntity<BuyItemsInCartResponse> buyItemsInCart (BaseRequest baseRequest , HttpServletRequest request);

    @GetMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_PAYMENT_SERVICE_QUERY_BY_TRACKING_NUMBER)
    ResponseEntity<QueryTrackingNumberResponse> queryByTrackingNumber(@RequestParam("trackingnumber") String trackingNumber, BaseRequest baseRequest);

}
