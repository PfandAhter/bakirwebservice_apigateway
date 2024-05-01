package com.bws.apigateway.api.response;

import com.bws.apigateway.model.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class ProductListResponse {

    private List<ProductDTO> productList;

}
