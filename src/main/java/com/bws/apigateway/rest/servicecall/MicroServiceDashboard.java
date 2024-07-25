package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.client.MicroServiceRegisterClient;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.response.GetMicroServicesDashboardResponse;
import com.bws.apigateway.model.entity.LogApiGateway;
import com.bws.apigateway.repository.LogApiGatewayRepository;
import com.bws.apigateway.rest.servicecall.interfaces.IMicroServiceDashboardCall;
import com.bws.apigateway.rest.util.LogApiGatewayFactory;
import com.bws.apigateway.rest.util.ServiceNameProvider;
import com.bws.apigateway.rest.util.Util;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class MicroServiceDashboard implements IMicroServiceDashboardCall, ServiceNameProvider {

    private final MicroServiceRegisterClient microServiceRegisterClient;

    @Override
    public String getServiceName() {
        return "micro-services";
    }

    @Override
    public GetMicroServicesDashboardResponse getMicroServicesDashboardResponse (BaseRequest request){
        return microServiceRegisterClient.microServiceDashboard(request);
    }

}
