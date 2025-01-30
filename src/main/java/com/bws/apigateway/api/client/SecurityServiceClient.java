package com.bws.apigateway.api.client;


import com.bws.apigateway.api.response.CheckCanAccess;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SecurityService" , url = "${client.feign.security-service.path}")
public interface SecurityServiceClient {

    @GetMapping("/hasAccessToPath")
    CheckCanAccess hasAccessToPath(@RequestParam("url") String url, @RequestParam("role") String role);
}
