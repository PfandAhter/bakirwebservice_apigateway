package com.bws.apigateway.rest.controller;

import com.bws.apigateway.api.request.AddBalanceRequest;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.CreateOrderRequest;
import com.bws.apigateway.api.request.DeleteOrderByProductCodeRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.BuyOrdersOnCartTrackingNumberResponse;
import com.bws.apigateway.api.response.GetBalanceResponse;
import com.bws.apigateway.model.constants.PropertyConstants;
import com.bws.apigateway.model.dto.OrderListDTO;
import com.bws.apigateway.rest.controller.api.IndexRestServiceApi;
import com.bws.apigateway.rest.servicecall.IndexServiceCallImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = PropertyConstants.REQUEST_LOCKED_INDEXSERVICE)
@CrossOrigin
@RequiredArgsConstructor

public class IndexController implements IndexRestServiceApi {

    private final IndexServiceCallImpl serviceCall;

    @Override
    public ResponseEntity<BaseResponse> addBalance(AddBalanceRequest addBalanceRequest, HttpServletRequest request, BindingResult bindingResult) {
        return ResponseEntity.ok(serviceCall.addBalanceServiceCall(addBalanceRequest));
    }

    @Override
    public ResponseEntity<GetBalanceResponse> getBalance(BaseRequest baseRequest, HttpServletRequest request, BindingResult bindingResult){
        return ResponseEntity.ok(serviceCall.getBalanceServiceCall(baseRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> createOrder(CreateOrderRequest buyProductWithProductCodeRequest, HttpServletRequest request, BindingResult bindingResult) {
        return ResponseEntity.ok(serviceCall.createOrderList(buyProductWithProductCodeRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> deleteOrderByProductCode(DeleteOrderByProductCodeRequest deleteOrderByProductCodeRequest, HttpServletRequest request, BindingResult bindingResult) {
        return ResponseEntity.ok(serviceCall.deleteOrderByProductCode(deleteOrderByProductCodeRequest));
    }

    @Override
    public ResponseEntity<List<OrderListDTO>> getOrderList(BaseRequest baseRequest, HttpServletRequest request, BindingResult bindingResult) {
        return ResponseEntity.ok(serviceCall.getOrderList(baseRequest));
    }

    @PostMapping(path = "/buyorders")
    ResponseEntity<BuyOrdersOnCartTrackingNumberResponse> buyOrdersOnCartTrackingNumberResponseResponse (BaseRequest baseRequest){
        return ResponseEntity.ok(serviceCall.buyOrdersOnCartsAndReturnTrackingNumber(baseRequest));
    }




}
