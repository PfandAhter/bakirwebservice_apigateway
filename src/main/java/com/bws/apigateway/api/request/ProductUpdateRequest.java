package com.bws.apigateway.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductUpdateRequest extends ProductAddRequest{

    private String productId;

}
