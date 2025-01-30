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
import com.bws.apigateway.rest.util.ServiceNameProvider;
import com.bws.apigateway.rest.util.Util;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class StockServiceCallImpl implements IStockServiceCall, ServiceNameProvider {

    private final StockServiceClient stockServiceClient;

    @Override
    public String getServiceName() {
        return "stock-service";
    }

    //CATEGORY

    @Override
    public CategoryListResponse getCategoryListResponse(String categoryId) {
        return stockServiceClient.listCategoryRequest(categoryId);
    }

    @Override
    public BaseResponse addCategory (CategoryAddRequest request){
        return stockServiceClient.addCategoryRequest(request);
    }

    @Override
    public BaseResponse updateCategory (CategoryUpdateRequest request){
        return stockServiceClient.updateCategoryRequest(request);
    }

    //PRODUCT

    @Override
    public ProductListResponse getProductListResponse(String categoryId) {
        return stockServiceClient.listProductByCategoryIdRequest(categoryId);
    }

    @Override
    public BaseResponse addProduct (ProductAddRequest request){
        return stockServiceClient.addProductRequest(request);
    }

    @Override
    public BaseResponse updateProduct (ProductUpdateRequest request){
        return stockServiceClient.updateProductRequest(request);
    }

    @Override
    public ProductGetResponse getProductByProductId(String productId) {
        return stockServiceClient.getProduct(productId);
    }

    @Override
    public BaseResponse addCompany (CompanyAddRequest request){
        return stockServiceClient.addCompany(request);
    }

    @Override
    public BaseResponse addComment (String productId , CommentAddRequest commentAddRequest){
        return stockServiceClient.addComment(productId,commentAddRequest);
    }

}
