package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.model.dto.ProductDTO;
import com.bws.apigateway.model.entity.LogApiGateway;
import com.bws.apigateway.repository.LogApiGatewayRepository;
import com.bws.apigateway.rest.servicecall.interfaces.IProductServiceCall;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.bws.apigateway.model.constants.PropertyConstants.REST_TEMPLATE_REQUEST_MICROSERVICE_PRODUCT_SERVICE_PRODUCT_GETLIST;


@Service
@Slf4j
@RequiredArgsConstructor


public class ProductServiceCallImpl implements IProductServiceCall {

    private final RestTemplate restTemplate;

    private final LogApiGatewayRepository logApiGatewayRepository;

    @Value(REST_TEMPLATE_REQUEST_MICROSERVICE_PRODUCT_SERVICE_PRODUCT_GETLIST)
    private String getProductListPath;

    public List<ProductDTO> getProductListResponse(BaseRequest request) {
        logInDataBase(request.getClass().getName(),ArrayList.class.getName());
        return restTemplate.postForObject(getProductListPath, request, ArrayList.class);
    }

    private void logInDataBase(String baseRequest, String responseType){
        logApiGatewayRepository.save(LogApiGateway.builder().fetchedMicroservice(
                        "ProductService")
                .requestType(baseRequest.substring(31,baseRequest.length()).toString())
                .error_code(0000L)
                .successfully(1)
                .responseType(responseType).build());
    }
}
