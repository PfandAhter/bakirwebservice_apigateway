package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.client.MicroServiceRegisterClient;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.response.GetMicroServicesDashboardResponse;
import com.bws.apigateway.rest.servicecall.interfaces.IMicroServiceDashboardCall;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MicroServiceDashboard implements IMicroServiceDashboardCall {

    private final MicroServiceRegisterClient microServiceRegisterClient;

    public GetMicroServicesDashboardResponse getMicroServicesDashboardResponse (BaseRequest request){
        //log to database
        return microServiceRegisterClient.microServiceDashboard(request);
    }

}
