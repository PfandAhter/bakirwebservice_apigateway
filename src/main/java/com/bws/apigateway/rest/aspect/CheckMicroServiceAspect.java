package com.bws.apigateway.rest.aspect;

import com.bws.apigateway.api.client.MicroServiceRegisterClient;
import com.bws.apigateway.exceptions.ServiceUnavailableException;
import com.bws.apigateway.model.entity.MicroService;
import com.bws.apigateway.rest.servicecall.interfaces.ICacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import static com.bws.apigateway.model.constants.ErrorCodeConstants.SERVICE_UNAVAILABLE;

import java.util.HashMap;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class CheckMicroServiceAspect {

    //private final MicroServiceRegisterClient microServiceRegisterClient;

    //TODO CHECK HERE
    private final ICacheService cacheService;
    private HashMap<String, MicroService> microServiceList;

    @Before(value = "execution(* com.bws.apigateway.rest.servicecall.AuthServiceCallImpl..*(..)) ")
    public void checkAuthServiceCall() throws ServiceUnavailableException {
        /*microServiceList = cacheService.microServiceList();

        if((microServiceRegisterClient.checkMicroServiceStatus(
                microServiceList.get("AUTHENTICATION-SERVICE").getMicroServiceCode()))){
            log.error("Authentication service is not available");
            throw new ServiceUnavailableException(SERVICE_UNAVAILABLE);
        }
            log.info("Authentication service called");*/
    }

    @Before(value = "execution(* com.bws.apigateway.rest.servicecall.MessageServiceCallImpl..*(..)) ")
    public void checkMessageServiceCall() throws ServiceUnavailableException {
        /*microServiceList = cacheService.microServiceList();

        if((microServiceRegisterClient.checkMicroServiceStatus(
                microServiceList.get("MESSAGE-SERVICE").getMicroServiceCode()))){
            log.error("Message service is not available");
            throw new ServiceUnavailableException(SERVICE_UNAVAILABLE);
        }
        log.info("Message service called");*/
    }

    @Before(value = "execution(* com.bws.apigateway.rest.servicecall.MicroServiceDashboard..*(..)) ")
    public void checkMicroServiceDashboardServiceCall() throws ServiceUnavailableException {
        /*microServiceList = cacheService.microServiceList();

        if((microServiceRegisterClient.checkMicroServiceStatus(
                microServiceList.get("REGISTER-SERVICE").getMicroServiceCode()))){
            log.error("Register service is not available");
            throw new ServiceUnavailableException(SERVICE_UNAVAILABLE);
        }
        log.info("Register service called");*/
    }

    @Before(value = "execution(* com.bws.apigateway.rest.servicecall.PaymentServiceCallImpl..*(..)) ")
    public void checkPaymentServiceCall() throws ServiceUnavailableException {
        /*microServiceList = cacheService.microServiceList();

        if((microServiceRegisterClient.checkMicroServiceStatus(
                microServiceList.get("PAYMENT-SERVICE").getMicroServiceCode()))){
            log.error("Payment service is not available");
            throw new ServiceUnavailableException(SERVICE_UNAVAILABLE);
        }
        log.info("Payment service called");*/
    }

    @Before(value = "execution(* com.bws.apigateway.rest.servicecall.StockServiceCallImpl..*(..)) ")
    public void checkStockServiceCall() throws ServiceUnavailableException {
        /*microServiceList = cacheService.microServiceList();

        if((microServiceRegisterClient.checkMicroServiceStatus(
                microServiceList.get("STOCK-SERVICE").getMicroServiceCode()))){
            log.error("Stock service is not available");
            throw new ServiceUnavailableException(SERVICE_UNAVAILABLE);
        }
        log.info("Stock service called");*/
    }

    @Before(value = "execution(* com.bws.apigateway.rest.servicecall.UserServiceCallImpl..*(..)) ")
    public void checkUserServiceCall() throws ServiceUnavailableException {
        /*microServiceList = cacheService.microServiceList();

        if((microServiceRegisterClient.checkMicroServiceStatus(
                microServiceList.get("USER-SERVICE").getMicroServiceCode()))){
            log.error("User service is not available");
            throw new ServiceUnavailableException(SERVICE_UNAVAILABLE);
        }
        log.info("User service called");*/
    }




}
