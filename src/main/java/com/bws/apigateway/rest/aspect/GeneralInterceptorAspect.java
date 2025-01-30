package com.bws.apigateway.rest.aspect;

import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.model.entity.ErrorCodes;
import com.bws.apigateway.repository.ErrorCodeRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class GeneralInterceptorAspect {

    private final HttpServletRequest request;

    @Before(value = "execution(* com.bws.apigateway.exceptions.GlobalExceptionHandler..*(..)) ")
    public void beforeException(JoinPoint joinPoint){
        Object [] parameters = joinPoint.getArgs();
        for(Object param : parameters){
            if(param instanceof Exception){

            }
        }
    }

    @Before(value = "execution(* com.bws.apigateway.rest.controller..*(..)) ")
    public void beforeController (JoinPoint joinPoint){
        Object [] parameters = joinPoint.getArgs();
        for(Object param : parameters){
            if(param instanceof BaseRequest){
                ((BaseRequest) param).setToken(request.getHeader("Authorization"));
            }
        }
    }

    /*@Before(value = "execution(* com.bws.apigateway.rest.controller..*(..))")
    public void addRoleBeforeExecControllers (JoinPoint joinPoint){
        Object [] paramters = joinPoint.getArgs();

        for(Object param : paramters){
            if(param instanceof BaseRequest){
                ((BaseRequest) param).setRole(Role.valueOf(request.getHeader("Role")));
            }
        }

    }*/

}
