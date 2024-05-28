package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.client.PaymentServiceClient;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.AddItemsInCartRequest;
import com.bws.apigateway.api.response.*;
import com.bws.apigateway.model.entity.LogApiGateway;
import com.bws.apigateway.repository.LogApiGatewayRepository;
import com.bws.apigateway.rest.servicecall.interfaces.IPaymentServiceCall;
import com.bws.apigateway.rest.util.Util;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor

public class PaymentServiceCallImpl implements IPaymentServiceCall {

    private final LogApiGatewayRepository logApiGatewayRepository;

    private final PaymentServiceClient paymentServiceClient;

    private static final String serviceName = "payment-service";

    @Override
    @Transactional
    public BaseResponse addItemsInCart(AddItemsInCartRequest request){
        logInDataBase(serviceName,AddItemsInCartRequest.class.getName(),BaseResponse.class.getName());
        return paymentServiceClient.addItemInCart(request);
    }

    @Override
    @Transactional
    public BaseResponse clearItemsInCart(BaseRequest request){
//                logInDataBase("Stock-Service",request.getClass().getName(),BuyProductWithCodeResponse.class.getName());
        return null;
    }

    @Override
    @Transactional
    public GetProductDetailsResponse getItemsInCart(BaseRequest request){
        logInDataBase(serviceName,BaseRequest.class.getName(),GetProductDetailsResponse.class.getName());
        return paymentServiceClient.getItemsInCart(request);
    }

    @Override
    @Transactional
    public BuyItemsInCartResponse buyItemsInCart (BaseRequest request){
        logInDataBase(serviceName,BaseRequest.class.getName(),BuyItemsInCartResponse.class.getName());
        return paymentServiceClient.buyItemsInCart(request);
    }

    @Override
    @Transactional
    public QueryTrackingNumberResponse queryWithTrackingNumber(String trackingNumber , BaseRequest baseRequest){
        logInDataBase(serviceName,BaseRequest.class.getName(),QueryTrackingNumberResponse.class.getName());
        return paymentServiceClient.queryByTrackingNumber(trackingNumber , baseRequest);
    }

    @Transactional
    @Override
    public void logInDataBase(String serviceName,String baseRequest, String responseType){
        logApiGatewayRepository.save(LogApiGateway.builder().fetchedMicroservice(
                        serviceName)
                        .logId(Util.generateCode())
                .requestType(baseRequest)
                .error_code(0000L)
                .successfully(1)
                .responseType(responseType).build());
    }
}
