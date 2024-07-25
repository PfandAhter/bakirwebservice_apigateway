package com.bws.apigateway.rest.aspect;

import com.bws.apigateway.model.entity.LogApiGateway;
import com.bws.apigateway.repository.LogApiGatewayRepository;
import com.bws.apigateway.rest.util.LogApiGatewayFactory;
import com.bws.apigateway.rest.util.ServiceNameProvider;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAspect {

    private final LogApiGatewayRepository logApiGatewayRepository;

    @Pointcut("execution(* com.bws.apigateway.rest.servicecall.*.*(..))")
    public void serviceMethods() {

    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "response")
    public void logAfterReturning(JoinPoint joinPoint, Object response){

        Object targetObject = joinPoint.getTarget();

        if (targetObject instanceof ServiceNameProvider) {
            String serviceName = ((ServiceNameProvider) targetObject).getServiceName();
            String requestType = joinPoint.getArgs()[0].getClass().getSimpleName();
            String responseType = response.getClass().getName();

            LogApiGateway log = LogApiGatewayFactory.createLog(serviceName,requestType,responseType);
            logApiGatewayRepository.save(log);
        }
    }


}
