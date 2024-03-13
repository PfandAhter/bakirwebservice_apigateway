package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.exceptions.ServiceUnavailableException;
import com.bws.apigateway.model.constants.Constants;
import com.bws.apigateway.model.dto.ProductDTO;
import com.bws.apigateway.rest.servicecall.interfaces.IProductServiceCall;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor


public class ProductServiceCallImpl implements IProductServiceCall {

    private final RestTemplate restTemplate;

    public List<ProductDTO> getProductListResponse(BaseRequest request) {
        return restTemplate.postForObject("http://localhost:8083/productservice/product/productlist", request, ArrayList.class);
    }
}
