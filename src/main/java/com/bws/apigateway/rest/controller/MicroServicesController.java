package com.bws.apigateway.rest.controller;

import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.response.GetMicroServicesDashboardResponse;
import com.bws.apigateway.rest.controller.api.MicroRestServiceApi;
import com.bws.apigateway.rest.servicecall.MicroServiceDashboard;
import com.bws.apigateway.rest.servicecall.interfaces.IMicroServiceDashboardCall;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("microservice")
@RequiredArgsConstructor
@Slf4j

public class MicroServicesController implements MicroRestServiceApi {

    private final IMicroServiceDashboardCall microServiceDashboard;

    @Override
    public ResponseEntity<GetMicroServicesDashboardResponse> microServiceDashboard(BaseRequest baseRequest, HttpServletRequest request) {
        return ResponseEntity.ok(microServiceDashboard.getMicroServicesDashboardResponse(baseRequest));
    }
}
