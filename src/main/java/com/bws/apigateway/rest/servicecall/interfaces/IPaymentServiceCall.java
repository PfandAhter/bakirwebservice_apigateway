package com.bws.apigateway.rest.servicecall.interfaces;

import com.bws.apigateway.api.request.AddItemsInCartRequest;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.BuyItemsInCartResponse;
import com.bws.apigateway.api.response.GetProductDetailsResponse;
import com.bws.apigateway.api.response.QueryTrackingNumberResponse;

public interface IPaymentServiceCall {

    BaseResponse addItemsInCart(AddItemsInCartRequest request);

    BaseResponse clearItemsInCart(BaseRequest request);

    GetProductDetailsResponse getItemsInCart(BaseRequest request);

    BuyItemsInCartResponse buyItemsInCart (BaseRequest request);

    QueryTrackingNumberResponse queryWithTrackingNumber(String trackingNumber , BaseRequest baseRequest);

    void logInDataBase(String serviceName,String baseRequest, String responseType);
}
