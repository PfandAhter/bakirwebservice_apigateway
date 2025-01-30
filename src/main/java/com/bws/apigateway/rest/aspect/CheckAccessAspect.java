package com.bws.apigateway.rest.aspect;

import com.bws.apigateway.api.client.SecurityServiceClient;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor

public class CheckAccessAspect {

    private final SecurityServiceClient securityServiceClient;

    @Before(value = "execution(* com.bws.apigateway.rest.controller..*(..))")
    public void checkCanAccessBeforeController(JoinPoint joinPoint){
        Object [] parameters = joinPoint.getArgs();
        for(Object param : parameters){
            if(param instanceof HttpServletRequest){
                HttpServletRequest request = (HttpServletRequest) param;
                securityServiceClient.hasAccessToPath(request.getRequestURI(),request.getHeader("ROLE"));
            }
        }
    }
}
