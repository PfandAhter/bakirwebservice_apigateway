package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.client.MicroServiceRegisterClient;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.response.GetMicroServicesDashboardResponse;
import com.bws.apigateway.model.entity.LogApiGateway;
import com.bws.apigateway.repository.LogApiGatewayRepository;
import com.bws.apigateway.rest.servicecall.interfaces.IMicroServiceDashboardCall;
import com.bws.apigateway.rest.util.Util;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MicroServiceDashboard implements IMicroServiceDashboardCall {

    private final MicroServiceRegisterClient microServiceRegisterClient;

    private final LogApiGatewayRepository logApiGatewayRepository;

    private static final String serviceName = "micro-services";

    @Override
    @Transactional
    public GetMicroServicesDashboardResponse getMicroServicesDashboardResponse (BaseRequest request){
        logInDataBase(serviceName,BaseRequest.class.getName(),GetMicroServicesDashboardResponse.class.getName());
        return microServiceRegisterClient.microServiceDashboard(request);
    }

    @Transactional
    @Override
    public void logInDataBase(String serviceName,String baseRequest, String responseType){
        logApiGatewayRepository.save(LogApiGateway.builder().fetchedMicroservice(
                        serviceName)
                .logId(Util.generateCode())
                .requestType(baseRequest)
                .error_code(99000L)
                .successfully(1)
                .responseType(responseType).build());
    }

}
