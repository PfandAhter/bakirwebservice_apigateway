package com.bws.apigateway.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AddItemsInCartRequest extends BaseRequest{

    private String productCode;

    private int orderQuantity;

}
