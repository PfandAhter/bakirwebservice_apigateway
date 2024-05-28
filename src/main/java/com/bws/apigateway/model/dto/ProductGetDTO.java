package com.bws.apigateway.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductGetDTO {

    private String productId;
    private String productName;
    private String companyId;
    private String categoryId;
    private int price;
    private int stock;
    private int commentCount;
    private String description;
    private List<CommentDTO> comments;

}
