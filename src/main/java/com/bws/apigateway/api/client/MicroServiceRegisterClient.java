package com.bws.apigateway.api.client;

import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.register.MicroServiceReadyRequest;
import com.bws.apigateway.api.request.register.MicroServiceStoppedRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.GetMicroServicesDashboardResponse;
import com.bws.apigateway.api.response.microservice.MicroServiceListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "MicroServiceRegister" , url = "${client.feign.microServiceRegister-service.path}")
public interface MicroServiceRegisterClient {

    @PostMapping("${client.feign.microServiceRegister-service.ready}")
    BaseResponse microServiceReady (@RequestBody MicroServiceReadyRequest microServiceReadyRequest);

    @PostMapping("${client.feign.microServiceRegister-service.stopped}")
    BaseResponse microServiceStopped (@RequestBody MicroServiceStoppedRequest microServiceStoppedRequest);

    @GetMapping("${client.feign.microServiceRegister-service.dashboard}")
    GetMicroServicesDashboardResponse microServiceDashboard (@RequestBody BaseRequest baseRequest);

    @GetMapping("${client.feign.microServiceRegister-service.check}")
    Boolean checkMicroServiceStatus (@RequestParam String microServiceCode);

    @GetMapping("${client.feign.microServiceRegister-service.list}")
    MicroServiceListResponse microServiceList ();
}
