package com.bws.apigateway.api.client;

import com.bws.apigateway.api.request.AddItemsInCartRequest;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.BuyItemsInCartResponse;
import com.bws.apigateway.api.response.GetProductDetailsResponse;
import com.bws.apigateway.api.response.QueryTrackingNumberResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "PaymentService", url = "${client.feign.payment-service.path}")
public interface PaymentServiceClient {

    @PostMapping("${client.feign.payment-service.cart.addItemInCart}")
    BaseResponse addItemInCart(@RequestBody AddItemsInCartRequest addItemsInCartRequest);

    @PostMapping("${client.feign.payment-service.cart.getItemListInCart}")
    GetProductDetailsResponse getItemsInCart(@RequestBody BaseRequest baseRequest);

    @PostMapping("${client.feign.payment-service.cart.buyItemsInCart}")
    BuyItemsInCartResponse buyItemsInCart (@RequestBody BaseRequest baseRequest);

    @PostMapping("${client.feign.payment-service.cart.queryByTrackingNumber}")
    QueryTrackingNumberResponse queryByTrackingNumber (@RequestParam("trackingnumber") String trackingNumber , @RequestBody BaseRequest baseRequest);

}
