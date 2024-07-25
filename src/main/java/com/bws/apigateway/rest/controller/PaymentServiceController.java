package com.bws.apigateway.rest.controller;

import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.AddItemsInCartRequest;
import com.bws.apigateway.api.response.*;
import com.bws.apigateway.model.constants.PropertyConstants;
import com.bws.apigateway.rest.controller.api.PaymentRestServiceApi;
import com.bws.apigateway.rest.servicecall.PaymentServiceCallImpl;
import com.bws.apigateway.rest.servicecall.interfaces.IPaymentServiceCall;
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

    private final IPaymentServiceCall paymentServiceCall;

    @Override
    public ResponseEntity<BaseResponse> addItemsInCart(AddItemsInCartRequest buyProductWithProductCodeRequest, HttpServletRequest request, BindingResult bindingResult) {
        return ResponseEntity.ok(paymentServiceCall.addItemsInCart(buyProductWithProductCodeRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> clearItemsInCart(BaseRequest baseRequest, HttpServletRequest request, BindingResult bindingResult) {
        return ResponseEntity.ok(paymentServiceCall.clearItemsInCart(baseRequest));
    }

    @Override
    public ResponseEntity<GetProductDetailsResponse> getItemsInCart(BaseRequest baseRequest, HttpServletRequest request) {
        return ResponseEntity.ok(paymentServiceCall.getItemsInCart(baseRequest));
    }

    @Override
    public ResponseEntity<BuyItemsInCartResponse> buyItemsInCart(BaseRequest baseRequest, HttpServletRequest request) {
        return ResponseEntity.ok(paymentServiceCall.buyItemsInCart(baseRequest));
    }

    @Override
    public ResponseEntity<QueryTrackingNumberResponse> queryWithTrackingNumber(String trackingNumber , BaseRequest baseRequest) {
        return ResponseEntity.ok(paymentServiceCall.queryWithTrackingNumber(trackingNumber , baseRequest));
    }

}
