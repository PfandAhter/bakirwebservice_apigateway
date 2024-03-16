package com.bws.apigateway.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BuyOrdersOnCartTrackingNumberResponse extends BaseResponse{
    private Long trackingNumber;

}
