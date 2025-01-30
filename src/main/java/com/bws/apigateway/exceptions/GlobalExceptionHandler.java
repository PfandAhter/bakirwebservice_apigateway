package com.bws.apigateway.exceptions;

import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.model.constants.Constants;
import com.bws.apigateway.model.constants.ErrorCodeConstants;
import com.bws.apigateway.model.entity.ErrorCodes;
import com.bws.apigateway.rest.servicecall.interfaces.ICacheService;
import feign.FeignException;
import feign.RetryableException;
import jakarta.security.auth.message.AuthException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

import static com.bws.apigateway.model.constants.ResponseStatus.FAILED;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor

public class GlobalExceptionHandler {

    private final HttpServletResponse response;

    private final ICacheService cacheService;

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<BaseResponse> handleException(RuntimeException e) {
//        log.error("Error: " + e);
//        return ResponseEntity.internalServerError().body(createFailResponse(e.getMessage().split("HataMesaji")[1].substring(3,e.getMessage().split("HataMesaji")[1].length()-3)));
//
//    }

    @ExceptionHandler(jakarta.security.auth.message.AuthException.class)
    public ResponseEntity<BaseResponse> handleException(AuthException e) {
        return ResponseEntity.badRequest().body(createFailResponse(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> handleException(Exception e) {
        return ResponseEntity.badRequest().body(createFailResponse(e.getMessage()));
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<BaseResponse> handleException(FeignException e){
        return ResponseEntity.badRequest().body(createFailResponse("ACCESS DENIED"));
    }

    @ExceptionHandler(ServiceUnavailableException.class)
    public ResponseEntity<BaseResponse> handlException (ServiceUnavailableException e){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(createFailResponseBody(e.getMessage()));
    }

    @ExceptionHandler(FeignException.FeignClientException.class)
    public ResponseEntity<BaseResponse> handleException(FeignException.FeignClientException e){
        return ResponseEntity.badRequest().body(createFailResponse(e.getMessage()));
    }

//    @ExceptionHandler(FeignException.InternalServerError.class)
//    public ResponseEntity<BaseResponse> handleException(FeignException.InternalServerError e){
//        return ResponseEntity.badRequest().body(createFailResponse(ErrorCodeConstants.SERVICE_UNAVAILABLE));
//    }

    @ExceptionHandler(FeignException.BadRequest.class)
    public ResponseEntity<BaseResponse> handleException(FeignException.BadRequest e){
        String exceptionMessage = e.getMessage().split("HataMesaji")[1];
        return ResponseEntity.badRequest().body(createFailResponse(exceptionMessage.substring(3,exceptionMessage.length()-3)));
    }

    @ExceptionHandler(RetryableException.class)
    public ResponseEntity<BaseResponse> handleException(RetryableException e){
        setResponseStatus(response);
        return ResponseEntity.badRequest().body(createFailResponse(ErrorCodeConstants.SERVICE_UNAVAILABLE));
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<BaseResponse> handleException(ResourceAccessException e){
        return ResponseEntity.badRequest().body(createFailResponse(ErrorCodeConstants.SERVICE_UNAVAILABLE));
    }

    private BaseResponse createFailResponse(String message) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus("0");
        baseResponse.setErrorCode(Constants.FAILED);
        baseResponse.setErrorDescription(message);
        return baseResponse;
    }

    private BaseResponse setResponseStatus (@NonNull HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return new BaseResponse();
    }

    private BaseResponse createFailResponseBody(String exceptionMessage){
        BaseResponse baseResponse = new BaseResponse();
        ErrorCodes errorCodes = cacheService.getErrorCodesList().get(exceptionMessage);
        baseResponse.setStatus(errorCodes.getId());
        baseResponse.setErrorCode(errorCodes.getError());
        baseResponse.setErrorDescription(errorCodes.getDescription());
        return baseResponse;
    }
}

