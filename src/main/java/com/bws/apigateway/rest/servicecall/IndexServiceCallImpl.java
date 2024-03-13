package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.request.AddBalanceRequest;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.GetBalanceResponse;
import com.bws.apigateway.rest.servicecall.interfaces.IIndexServiceCall;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
@RequiredArgsConstructor

public class IndexServiceCallImpl implements IIndexServiceCall {

    private final RestTemplate restTemplate;

    @Override
    public BaseResponse addBalanceServiceCall(AddBalanceRequest request) {
        return restTemplate.postForObject("http://localhost:8078/paymentservice/addbalance", request, BaseResponse.class);

    }

    public GetBalanceResponse getBalanceServiceCall(BaseRequest request) {
        return restTemplate.postForObject("http://localhost:8078/paymentservice/getbalance", request, GetBalanceResponse.class);

    }

}
