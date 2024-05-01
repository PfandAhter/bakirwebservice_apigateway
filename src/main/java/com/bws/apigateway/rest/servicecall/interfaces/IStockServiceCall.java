package com.bws.apigateway.rest.servicecall.interfaces;

import com.bws.apigateway.api.request.*;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.CategoryListResponse;
import com.bws.apigateway.api.response.ProductGetResponse;
import com.bws.apigateway.api.response.ProductListResponse;

public interface IStockServiceCall {

    CategoryListResponse getCategoryListResponse(String categoryId);

    BaseResponse addCategory(CategoryAddRequest request);

    BaseResponse updateCategory(CategoryUpdateRequest request);

    ProductListResponse getProductListResponse(String categoryId);

    BaseResponse addProduct(ProductAddRequest request);

    BaseResponse updateProduct(ProductUpdateRequest request);

    ProductGetResponse getProductByProductId(String productId);

}
