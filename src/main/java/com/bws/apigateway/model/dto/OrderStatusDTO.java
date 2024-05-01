package com.bws.apigateway.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OrderStatusDTO {

    private String productCode;
    private int orderQuantity;
    private String status;
}
