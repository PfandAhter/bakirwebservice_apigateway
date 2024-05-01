package com.bws.apigateway.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductDTO {

    private String productId;
    private String productName;
    private String companyId;
    private String categoryId;
    private int price;
    private int stock;
    private String description;
}
