package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.client.StockServiceClient;
import com.bws.apigateway.api.request.*;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.CategoryListResponse;
import com.bws.apigateway.api.response.ProductGetResponse;
import com.bws.apigateway.api.response.ProductListResponse;
import com.bws.apigateway.model.entity.LogApiGateway;
import com.bws.apigateway.repository.LogApiGatewayRepository;
import com.bws.apigateway.rest.servicecall.interfaces.IStockServiceCall;
import com.bws.apigateway.rest.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor


public class StockServiceCallImpl implements IStockServiceCall {

    private final LogApiGatewayRepository logApiGatewayRepository;

    private final StockServiceClient stockServiceClient;

    //CATEGORY

    @Override
    public CategoryListResponse getCategoryListResponse(String categoryId) {
        logInDataBase(String.class.getName(),CategoryListResponse.class.getName());
        return stockServiceClient.listCategoryRequest(categoryId);
    }

    @Override
    public BaseResponse addCategory (CategoryAddRequest request){
        logInDataBase(CategoryAddRequest.class.getName(),BaseResponse.class.getName());
        return stockServiceClient.addCategoryRequest(request);
    }

    @Override
    public BaseResponse updateCategory (CategoryUpdateRequest request){
        logInDataBase(CategoryUpdateRequest.class.getName(),BaseResponse.class.getName());
        return stockServiceClient.updateCategoryRequest(request);
    }

    //PRODUCT

    @Override
    public ProductListResponse getProductListResponse(String categoryId) {
        logInDataBase(String.class.getName(),ProductListResponse.class.getName());
        return stockServiceClient.listProductByCategoryIdRequest(categoryId);
    }

    @Override
    public BaseResponse addProduct (ProductAddRequest request){
        logInDataBase(ProductAddRequest.class.getName(),BaseResponse.class.getName());
        return stockServiceClient.addProductRequest(request);
    }

    @Override
    public BaseResponse updateProduct (ProductUpdateRequest request){
        logInDataBase(ProductUpdateRequest.class.getName(),BaseResponse.class.getName());
        return stockServiceClient.updateProductRequest(request);
    }

    @Override
    public ProductGetResponse getProductByProductId(String productId) {
        logInDataBase(String.class.getName(),ProductGetResponse.class.getName());
        return stockServiceClient.getProduct(productId);
    }

    public BaseResponse addCompany (CompanyAddRequest request){
        //logtodatabase
        return stockServiceClient.addCompany(request);
    }

    private void logInDataBase(String requestType, String responseType){
        logApiGatewayRepository.save(LogApiGateway.builder().fetchedMicroservice(
                        "StockService")
                .logId(Util.generateCode())
                .requestType(requestType)
                .error_code(0000L)
                .successfully(1)
                .responseType(responseType).build());
    }
}
