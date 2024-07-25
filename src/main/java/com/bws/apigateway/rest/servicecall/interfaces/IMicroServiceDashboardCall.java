package com.bws.apigateway.rest.servicecall.interfaces;

import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.response.GetMicroServicesDashboardResponse;

public interface IMicroServiceDashboardCall {
    GetMicroServicesDashboardResponse getMicroServicesDashboardResponse (BaseRequest request);

}
