package com.bws.apigateway.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductDTO {

    private String productName;
    private String companyName;
    private String categoryName;
    private int price;
    private int stock;
    private String description;
}
