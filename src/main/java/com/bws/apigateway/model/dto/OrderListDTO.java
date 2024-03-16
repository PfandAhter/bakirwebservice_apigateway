package com.bws.apigateway.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OrderListDTO {
    private String productName;
    private String companyName;
    private String categoryName;
    private Long amount;
    private String status;
    private String description;

}
