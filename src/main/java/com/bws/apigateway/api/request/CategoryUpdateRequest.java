package com.bws.apigateway.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryUpdateRequest extends CategoryAddRequest {

    @NotBlank(message = "categoryId NOT NULL")
    private String categoryId;

}
