package com.bws.apigateway.model.dto;


import com.bws.apigateway.model.entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter

public class CategoryDTO {

    private String categoryId;

    private String parentId;

    private String categoryName;

    private String status;

    private Set<Category> children;

}
