package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.client.MicroServiceRegisterClient;
import com.bws.apigateway.api.response.microservice.MicroServiceListResponse;
import com.bws.apigateway.model.entity.ErrorCodes;
import com.bws.apigateway.model.entity.MicroService;
import com.bws.apigateway.repository.ErrorCodeRepository;
import com.bws.apigateway.rest.servicecall.interfaces.ICacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class CacheServiceImpl implements ICacheService {

    private static final HashMap<String, MicroService> microServiceList = new HashMap<>();

    private static final HashMap<String,ErrorCodes> errorCodeList = new HashMap<>();

    private final ErrorCodeRepository errorCodeRepository;

    private final MicroServiceRegisterClient microServiceRegisterClient;

    public void getMicroServices() {
        try {
            MicroServiceListResponse microServices = microServiceRegisterClient.microServiceList();
            for (MicroService microService: microServices.getMicroServiceList()) {
                microServiceList.put(microService.getName(),microService);
            }
        } catch (Exception e) {
            log.error("Error in getting micro services from database");
        }
    }

    @Override
    public HashMap<String, MicroService> microServiceList() {
        return microServiceList;
    }


    public void getErrorCodes() {
        try {
            List<ErrorCodes> errorCodes = errorCodeRepository.findAll();
            if (errorCodes != null) {
                errorCodes.forEach(errorCode -> errorCodeList.put(errorCode.getId(),errorCode));
            }
        } catch (Exception e) {
            log.error("Error in getting error codes from database");
        }
    }

    @Override
    public HashMap<String, ErrorCodes> getErrorCodesList() {
        return errorCodeList;
    }







}
