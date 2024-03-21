package com.bws.apigateway.api.client;


import com.bws.apigateway.api.request.AuthUserRequest;
import com.bws.apigateway.api.request.UserAddRequest;
import com.bws.apigateway.api.response.AuthUserResponse;
import com.bws.apigateway.api.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "AuthService", url = "${feign.client.user-service.path}")
public interface AuthServiceClient {

    @PostMapping("${feign.client.user-service.login}")
    AuthUserResponse loginRequest (@RequestBody AuthUserRequest request);

    @PostMapping("${feign.client.user-service.register}")
    BaseResponse registerReqeust (@RequestBody UserAddRequest request);
}
