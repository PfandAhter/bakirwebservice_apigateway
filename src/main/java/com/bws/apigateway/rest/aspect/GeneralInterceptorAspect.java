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

    private final ErrorCodeRepository errorCodeRepository;

    @Before(value = "execution(* com.bws.apigateway.exceptions.GlobalExceptionHandler..*(..)) ")
    public void beforceException (JoinPoint joinPoint){
        Object [] parameters = joinPoint.getArgs();
        for(Object param : parameters){
            if(param instanceof Exception){
                if(errorCodeRepository.findErrorByError(param.getClass().getName()) == null){
                    ErrorCodes errorCodes = new ErrorCodes();
                    errorCodes.setError(param.getClass().getName());
                    errorCodes.setError_description(((Exception) param).getMessage().substring(0,((Exception) param).getMessage().length()));
                    errorCodeRepository.save(errorCodes);
                    Long localCode = 4000L;
                    errorCodes.setError_code(errorCodes.getId()+localCode);
                    errorCodeRepository.save(errorCodes);
                }
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
}
