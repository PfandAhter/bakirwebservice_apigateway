package com.bws.apigateway.api.response;

import com.bws.apigateway.model.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductGetResponse {
    private ProductDTO productDTO;

}
