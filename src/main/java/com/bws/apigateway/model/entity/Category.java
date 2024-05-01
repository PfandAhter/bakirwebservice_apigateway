package com.bws.apigateway.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Category {

    private String categoryId;
    private String parentId;
    private String categoryName;
    private String status;
    private Set<Category> children;
}
