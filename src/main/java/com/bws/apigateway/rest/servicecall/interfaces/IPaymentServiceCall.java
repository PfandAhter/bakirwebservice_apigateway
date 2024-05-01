package com.bws.apigateway.rest.servicecall.interfaces;

import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.response.BuyItemsInCartResponse;

public interface IPaymentServiceCall {

    BuyItemsInCartResponse buyItemsInCart (BaseRequest request);
}
