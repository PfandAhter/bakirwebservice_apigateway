package com.bws.apigateway.rest.servicecall.interfaces;

import com.bws.apigateway.api.request.AddBalanceRequest;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.GetBalanceResponse;
import com.bws.apigateway.exceptions.ServiceUnavailableException;

public interface IIndexServiceCall {

    BaseResponse addBalanceServiceCall (AddBalanceRequest request);

    GetBalanceResponse getBalanceServiceCall(BaseRequest request);
}
