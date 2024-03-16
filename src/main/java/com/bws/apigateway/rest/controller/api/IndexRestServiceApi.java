package com.bws.apigateway.rest.controller.api;

import com.bws.apigateway.api.request.AddBalanceRequest;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.CreateOrderRequest;
import com.bws.apigateway.api.request.DeleteOrderByProductCodeRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.GetBalanceResponse;
import com.bws.apigateway.model.constants.PropertyConstants;
import com.bws.apigateway.model.dto.OrderListDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IndexRestServiceApi {

    @PostMapping(path = PropertyConstants.REQUEST_INDEX_BALANCE_ADD,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> addBalance (@Valid @RequestBody AddBalanceRequest addBalanceRequest, HttpServletRequest request, BindingResult bindingResult);

    @PostMapping(path = PropertyConstants.REQUEST_INDEX_BALANCE_GET,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GetBalanceResponse> getBalance (@Valid @RequestBody BaseRequest baseRequest, HttpServletRequest request, BindingResult bindingResult);

    @PostMapping(path = PropertyConstants.REQUEST_INDEX_ORDER_LIST_ADD, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> createOrder(@Valid @RequestBody CreateOrderRequest buyProductWithProductCodeRequest, HttpServletRequest request, BindingResult bindingResult);

    @PostMapping(path = PropertyConstants.REQUEST_INDEX_ORDER_LIST_DELETE,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> deleteOrderByProductCode (@Valid @RequestBody DeleteOrderByProductCodeRequest deleteOrderByProductCodeRequest , HttpServletRequest request , BindingResult bindingResult);

    @PostMapping(path = PropertyConstants.REQUEST_INDEX_ORDER_LIST_GET ,produces = MediaType.APPLICATION_JSON_VALUE ,consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<OrderListDTO>> getOrderList (@Valid @RequestBody BaseRequest baseRequest , HttpServletRequest request, BindingResult bindingResult);


}
