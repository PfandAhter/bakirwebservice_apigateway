package com.bws.apigateway.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GetCategoryListRequest extends BaseRequest{
    private String categoryName;
}
