package com.bws.apigateway.rest.util;

import com.bws.apigateway.model.entity.LogApiGateway;


public class LogApiGatewayFactory {

    public static LogApiGateway createLog(String serviceName, String requestType, String responseType) {
        return LogApiGateway.builder()
                .fetchedMicroservice(serviceName)
                .logId(Util.generateCode())
                .requestType(requestType)
                .error_code(5000L)
                .successfully(1)
                .responseType(responseType)
                .build();
    }
}
