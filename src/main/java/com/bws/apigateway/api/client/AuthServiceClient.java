package com.bws.apigateway.api.client;


import com.bws.apigateway.api.request.*;
import com.bws.apigateway.api.response.AuthUserResponse;
import com.bws.apigateway.api.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "AuthService", url = "${client.feign.auth-service.path}")
public interface AuthServiceClient {

    @PostMapping("${client.feign.auth-service.login}")
    AuthUserResponse loginRequest (@RequestBody AuthUserRequest request);

    @PostMapping("${client.feign.auth-service.register}")
    BaseResponse registerRequest(@RequestBody UserAddRequest request);

    @PostMapping("${client.feign.auth-service.changePassword}")
    BaseResponse changePassword(@RequestBody PasswordChangeRequest request);

    @PostMapping("${client.feign.auth-service.logoutUser}")
    BaseResponse logoutUser (@RequestBody BaseRequest baseRequest);

    @PostMapping("${client.feign.auth-service.registerSellerRequest}")
    BaseResponse registerSellerRequest (@RequestBody SellerAddRequest sellerAddRequest);

}
