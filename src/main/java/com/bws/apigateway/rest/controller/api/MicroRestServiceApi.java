package com.bws.apigateway.rest.controller.api;

import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.response.GetMicroServicesDashboardResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MicroRestServiceApi {

    @PostMapping(path = "dashboard", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GetMicroServicesDashboardResponse> microServiceDashboard (@RequestBody BaseRequest baseRequest , HttpServletRequest request);

}
