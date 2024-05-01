package com.bws.apigateway.rest.controller;

import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.AddItemRequest;
import com.bws.apigateway.api.request.DeleteOrderByProductCodeRequest;
import com.bws.apigateway.api.response.*;
import com.bws.apigateway.model.constants.PropertyConstants;
import com.bws.apigateway.rest.controller.api.PaymentRestServiceApi;
import com.bws.apigateway.rest.servicecall.PaymentServiceCallImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping(path = PropertyConstants.REQUEST_SECURE_SERVICE_PAYMENT_CONTROLLER)
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceController implements PaymentRestServiceApi {

    private final PaymentServiceCallImpl paymentServiceCall;

    @Override
    public ResponseEntity<BaseResponse> createOrder(AddItemRequest buyProductWithProductCodeRequest, HttpServletRequest request, BindingResult bindingResult) {
        return ResponseEntity.ok(paymentServiceCall.createOrderList(buyProductWithProductCodeRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> deleteOrderByProductCode(DeleteOrderByProductCodeRequest deleteOrderByProductCodeRequest, HttpServletRequest request, BindingResult bindingResult) {
        return ResponseEntity.ok(paymentServiceCall.deleteOrderByProductCode(deleteOrderByProductCodeRequest));
    }

    @Override
    public ResponseEntity<GetProductDetailsResponse> getOrderList(BaseRequest baseRequest, HttpServletRequest request) {
        return ResponseEntity.ok(paymentServiceCall.getOrderList(baseRequest));
    }

    @Override
    public ResponseEntity<BuyItemsInCartResponse> buyItemsInCart(BaseRequest baseRequest, HttpServletRequest request) {
        return ResponseEntity.ok(paymentServiceCall.buyItemsInCart(baseRequest));
    }

    @Override
    public ResponseEntity<QueryTrackingNumberResponse> queryByTrackingNumber(String trackingNumber , BaseRequest baseRequest) {
        return ResponseEntity.ok(paymentServiceCall.queryTrackingNumberResponse(trackingNumber , baseRequest));
    }

}
