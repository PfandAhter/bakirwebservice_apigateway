package com.bws.apigateway.api.response;

import com.bws.apigateway.model.dto.SellerDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class SellerGetResponse {

    private List<SellerDTO> sellerDTOList;
}
