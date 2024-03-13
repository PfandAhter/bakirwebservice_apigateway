package com.bws.apigateway.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SearchWithCategorynameRequest extends BaseRequest{
    private String categoryName;

}
