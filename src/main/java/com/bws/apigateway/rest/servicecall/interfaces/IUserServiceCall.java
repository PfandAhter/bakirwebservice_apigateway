package com.bws.apigateway.rest.servicecall.interfaces;

import com.bws.apigateway.api.request.AddBalanceRequest;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.GetBalanceResponse;

public interface IUserServiceCall {
    GetBalanceResponse getBalanceRequest (BaseRequest request);

    BaseResponse addBalanceRequest (AddBalanceRequest request);
}
