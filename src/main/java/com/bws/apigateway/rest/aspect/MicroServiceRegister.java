package com.bws.apigateway.rest.aspect;

import com.bws.apigateway.api.client.MicroServiceRegisterClient;
import com.bws.apigateway.api.request.register.MicroServiceReadyRequest;
import com.bws.apigateway.api.request.register.MicroServiceStoppedRequest;
import com.bws.apigateway.rest.servicecall.CacheServiceImpl;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
@Component
@RequiredArgsConstructor
public class MicroServiceRegister {

    private final MicroServiceRegisterClient microServiceRegisterClient;

    private final CacheServiceImpl cacheService;

    private static final String microServiceCode = "AG5e16f689bce6438ba72746a8894608a9";

    private static final String microServiceName = "API-GATEWAY";

    @EventListener(ApplicationReadyEvent.class)
    public void logToDataBaseServiceReady(){
        //log.info("AVAILABLE CORE COUNT : " + Runtime.getRuntime().availableProcessors());

        /*MicroServiceReadyRequest microServiceReadyRequest = new MicroServiceReadyRequest();
        microServiceReadyRequest.setServiceCode(microServiceCode);
        microServiceReadyRequest.setServiceStatus("UP");
        microServiceReadyRequest.setErrorCode("4000");
        microServiceReadyRequest.setServiceReadyDate(Timestamp.from(Instant.now()));
        microServiceReadyRequest.setServiceName(microServiceName);

        cacheService.getMicroServices();
        cacheService.getErrorCodes();

        microServiceRegisterClient.microServiceReady(microServiceReadyRequest);*/
    }

    @PreDestroy
    public void testLogToDatabaseStopped(){
        /*MicroServiceStoppedRequest microServiceStoppedRequest = new MicroServiceStoppedRequest();
        microServiceStoppedRequest.setServiceStoppedDate(Timestamp.from(Instant.now()));
        microServiceStoppedRequest.setServiceName(microServiceName);
        microServiceStoppedRequest.setErrorCode("4000");
        microServiceStoppedRequest.setServiceStatus("DOWN");
        microServiceStoppedRequest.setServiceCode(microServiceCode);

        microServiceRegisterClient.microServiceStopped(microServiceStoppedRequest);*/
    }
}
