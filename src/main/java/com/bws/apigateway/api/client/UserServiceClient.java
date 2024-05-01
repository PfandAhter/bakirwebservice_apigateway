package com.bws.apigateway.api.client;

import com.bws.apigateway.api.request.AddAddressInfoRequest;
import com.bws.apigateway.api.request.AddBalanceRequest;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.EmailValidatorRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.GetBalanceResponse;
import com.bws.apigateway.api.response.SellerGetResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "UserService", url = "${client.feign.user-service.path}")
public interface UserServiceClient {

    @PostMapping("${client.feign.user-service.addBalance}")
    BaseResponse addBalanceRequest(@RequestBody AddBalanceRequest addBalanceRequest);

    @PostMapping("${client.feign.user-service.getBalance}")
    GetBalanceResponse getBalanceRequest (@RequestBody BaseRequest getBalanceRequest);

    @PostMapping("${client.feign.user-service.addAddressInfo}")
    BaseResponse addAddressInfo(@RequestBody AddAddressInfoRequest addAddressInfoRequest);

    @PostMapping("${client.feign.user-service.emailValidate}")
    BaseResponse emailValidate(@RequestBody EmailValidatorRequest emailValidatorRequest);

    @PostMapping("${client.feign.user-service.activateSellerByAdmin}")
    BaseResponse activateSellerByAdmin (@RequestParam("sellerid") String sellerId, @RequestBody BaseRequest baseRequest);

    @PostMapping("${client.feign.user-service.getSellers}")
    SellerGetResponse getSellers (@RequestParam("sellers") String sellers , @RequestBody BaseRequest baseRequest);
}
