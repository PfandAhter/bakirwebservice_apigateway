package com.bws.apigateway.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductAddRequest extends BaseRequest{

    @NotBlank(message = "productName NOT NULL")
    private String productName;

    private Long price;

    @NotBlank(message = "categoryId NOT NULL")
    private String categoryId;

    @NotBlank(message = "companyName NOT NULL")
    private String companyName;

    private int stock;

    @NotBlank(message = "description NOT NULL")
    private String description;

}