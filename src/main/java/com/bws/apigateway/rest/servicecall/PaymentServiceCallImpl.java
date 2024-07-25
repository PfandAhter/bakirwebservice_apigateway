package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.client.PaymentServiceClient;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.AddItemsInCartRequest;
import com.bws.apigateway.api.response.*;
import com.bws.apigateway.model.entity.LogApiGateway;
import com.bws.apigateway.repository.LogApiGatewayRepository;
import com.bws.apigateway.rest.servicecall.interfaces.IPaymentServiceCall;
import com.bws.apigateway.rest.util.LogApiGatewayFactory;
import com.bws.apigateway.rest.util.ServiceNameProvider;
import com.bws.apigateway.rest.util.Util;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class PaymentServiceCallImpl implements IPaymentServiceCall, ServiceNameProvider {

    private final PaymentServiceClient paymentServiceClient;

    @Override
    public String getServiceName() {
        return "payment-service";
    }

    @Override
    public BaseResponse addItemsInCart(AddItemsInCartRequest request){
        return paymentServiceClient.addItemInCart(request);
    }

    @Override
    public BaseResponse clearItemsInCart(BaseRequest request){
        return null;
    }

    @Override
    public GetProductDetailsResponse getItemsInCart(BaseRequest request){
        return paymentServiceClient.getItemsInCart(request);
    }

    @Override
    public BuyItemsInCartResponse buyItemsInCart (BaseRequest request){
        return paymentServiceClient.buyItemsInCart(request);
    }

    @Override
    public QueryTrackingNumberResponse queryWithTrackingNumber(String trackingNumber , BaseRequest baseRequest){
        return paymentServiceClient.queryByTrackingNumber(trackingNumber , baseRequest);
    }
}
