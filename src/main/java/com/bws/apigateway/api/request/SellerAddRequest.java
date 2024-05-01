package com.bws.apigateway.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SellerAddRequest extends UserAddRequest{

    private String sellerName;
    private String status;


}
