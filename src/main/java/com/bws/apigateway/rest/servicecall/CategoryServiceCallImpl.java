package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.GetCategoryListRequest;
import com.bws.apigateway.model.dto.CategoryDTO;
import com.bws.apigateway.model.dto.ProductDTO;
import com.bws.apigateway.model.entity.LogApiGateway;
import com.bws.apigateway.repository.LogApiGatewayRepository;
import com.bws.apigateway.rest.servicecall.interfaces.ICategoryServiceCall;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.bws.apigateway.model.constants.PropertyConstants.REST_TEMPLATE_REQUEST_MICROSERVICE_PRODUCT_SERVICE_CATEGORY_GETLIST;
import static com.bws.apigateway.model.constants.PropertyConstants.REST_TEMPLATE_REQUEST_MICROSERVICE_PRODUCT_SERVICE_PRODUCT_GETLISTBYCATEGORYNAME;

@Service
@Slf4j
@RequiredArgsConstructor

public class CategoryServiceCallImpl implements ICategoryServiceCall {

    private final RestTemplate restTemplate;

    private final LogApiGatewayRepository logApiGatewayRepository;

    @Value(REST_TEMPLATE_REQUEST_MICROSERVICE_PRODUCT_SERVICE_CATEGORY_GETLIST)
    private String getCategoryListPath;

    @Override
    public List<CategoryDTO> getCategoryListResponse(BaseRequest request) {
        logInDataBase(request.getClass().getName(),ArrayList.class.getName());
        return restTemplate.postForObject(getCategoryListPath, request, ArrayList.class);
    }

    @Value(REST_TEMPLATE_REQUEST_MICROSERVICE_PRODUCT_SERVICE_PRODUCT_GETLISTBYCATEGORYNAME)
    private String getProductlistByCategoryNamePath;

    @Override
    public List<ProductDTO> getProductListByCategoryName(GetCategoryListRequest request) {
        logInDataBase(request.getClass().getName(),ArrayList.class.getName());
        return restTemplate.postForObject(getProductlistByCategoryNamePath, request, ArrayList.class);
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
