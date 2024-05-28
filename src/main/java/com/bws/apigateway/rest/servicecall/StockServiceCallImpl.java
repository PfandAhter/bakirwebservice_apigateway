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
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor

public class StockServiceCallImpl implements IStockServiceCall {

    private final LogApiGatewayRepository logApiGatewayRepository;

    private final StockServiceClient stockServiceClient;

    private static final String serviceName = "stock-service";

    //CATEGORY

    @Override
    @Transactional
    public CategoryListResponse getCategoryListResponse(String categoryId) {
        logInDataBase(String.class.getName(),CategoryListResponse.class.getName());
        return stockServiceClient.listCategoryRequest(categoryId);
    }

    @Override
    @Transactional
    public BaseResponse addCategory (CategoryAddRequest request){
        logInDataBase(CategoryAddRequest.class.getName(),BaseResponse.class.getName());
        return stockServiceClient.addCategoryRequest(request);
    }

    @Override
    @Transactional
    public BaseResponse updateCategory (CategoryUpdateRequest request){
        logInDataBase(CategoryUpdateRequest.class.getName(),BaseResponse.class.getName());
        return stockServiceClient.updateCategoryRequest(request);
    }

    //PRODUCT

    @Override
    @Transactional
    public ProductListResponse getProductListResponse(String categoryId) {
        logInDataBase(String.class.getName(),ProductListResponse.class.getName());
        return stockServiceClient.listProductByCategoryIdRequest(categoryId);
    }

    @Override
    @Transactional
    public BaseResponse addProduct (ProductAddRequest request){
        logInDataBase(ProductAddRequest.class.getName(),BaseResponse.class.getName());
        return stockServiceClient.addProductRequest(request);
    }

    @Override
    @Transactional
    public BaseResponse updateProduct (ProductUpdateRequest request){
        logInDataBase(ProductUpdateRequest.class.getName(),BaseResponse.class.getName());
        return stockServiceClient.updateProductRequest(request);
    }

    @Override
    public ProductGetResponse getProductByProductId(String productId) {
        logInDataBase(String.class.getName(),ProductGetResponse.class.getName());
        return stockServiceClient.getProduct(productId);
    }

    @Override
    @Transactional
    public BaseResponse addCompany (CompanyAddRequest request){
        logInDataBase(CompanyAddRequest.class.getName(),BaseResponse.class.getName());
        return stockServiceClient.addCompany(request);
    }

    public BaseResponse addComment (String productId , CommentAddRequest commentAddRequest){
        //log to database

        return stockServiceClient.addComment(productId,commentAddRequest);
    }

    @Override
    @Transactional
    public void logInDataBase(String requestType, String responseType){
        logApiGatewayRepository.save(LogApiGateway.builder().fetchedMicroservice(
                        serviceName)
                .logId(Util.generateCode())
                .requestType(requestType)
                .error_code(2000L)
                .successfully(1)
                .responseType(responseType).build());
    }
}
