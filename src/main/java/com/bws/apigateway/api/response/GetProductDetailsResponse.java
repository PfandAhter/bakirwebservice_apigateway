package com.bws.apigateway.api.response;

import com.bws.apigateway.model.dto.ShoppingCartDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetProductDetailsResponse {
    List<ShoppingCartDTO> shoppingCartList;
    private Long totalAmount;
}

