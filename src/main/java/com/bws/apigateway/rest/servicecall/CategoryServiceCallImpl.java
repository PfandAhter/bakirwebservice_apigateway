package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.GetCategoryListRequest;
import com.bws.apigateway.model.dto.CategoryDTO;
import com.bws.apigateway.model.dto.ProductDTO;
import com.bws.apigateway.rest.servicecall.interfaces.ICategoryServiceCall;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class CategoryServiceCallImpl implements ICategoryServiceCall {

    private final RestTemplate restTemplate;

    public List<CategoryDTO> getCategoryListResponse(BaseRequest request) {
        return restTemplate.postForObject("http://localhost:8083/categoryservice/category/categorylist", request, ArrayList.class);
    }

    public List<ProductDTO> getProductListByCategoryName(GetCategoryListRequest request) {
        return restTemplate.postForObject("http://localhost:8083/productservice/product/categorylistbycategoryname", request, ArrayList.class);
    }
}
