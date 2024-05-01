package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.client.PaymentServiceClient;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.AddItemRequest;
import com.bws.apigateway.api.request.DeleteOrderByProductCodeRequest;
import com.bws.apigateway.api.response.*;
import com.bws.apigateway.model.entity.LogApiGateway;
import com.bws.apigateway.repository.LogApiGatewayRepository;
import com.bws.apigateway.rest.servicecall.interfaces.IPaymentServiceCall;
import com.bws.apigateway.rest.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor

public class PaymentServiceCallImpl implements IPaymentServiceCall {

    private final LogApiGatewayRepository logApiGatewayRepository;

    private final PaymentServiceClient paymentServiceClient;


    public BaseResponse createOrderList(AddItemRequest request){
//        logInDataBase("Stock-Service",request.getClass().getName(),BuyProductWithCodeResponse.class.getName());
        return paymentServiceClient.addItemInCart(request);
    }

    public BaseResponse deleteOrderByProductCode (DeleteOrderByProductCodeRequest request){
//                logInDataBase("Stock-Service",request.getClass().getName(),BuyProductWithCodeResponse.class.getName());
//        return restTemplate.postForObject(deleteOrderByProductCodeFromPaymentServicePath,request,BaseResponse.class);
        return null;
    }

    public GetProductDetailsResponse getOrderList (BaseRequest request){
//                logInDataBase("Stock-Service",request.getClass().getName(),BuyProductWithCodeResponse.class.getName());
        return paymentServiceClient.getItemsInCart(request);
    }

    @Override
    public BuyItemsInCartResponse buyItemsInCart (BaseRequest request){
        return paymentServiceClient.buyItemsInCart(request);
    }

    public QueryTrackingNumberResponse queryTrackingNumberResponse (String trackingNumber , BaseRequest baseRequest){
        return paymentServiceClient.queryByTrackingNumber(trackingNumber , baseRequest);
    }

    private void logInDataBase(String serviceName,String baseRequest, String responseType){
        logApiGatewayRepository.save(LogApiGateway.builder().fetchedMicroservice(
                        serviceName)
                        .logId(Util.generateCode())
                .requestType(baseRequest.substring(31,baseRequest.length()).toString())
                .error_code(0000L)
                .successfully(1)
                .responseType(responseType).build());
    }
}
