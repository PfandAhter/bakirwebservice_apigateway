package com.bws.apigateway.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateOrderRequest extends BaseRequest{
    private Long productCode;

    private int orderQuantity;

}
