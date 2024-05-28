package com.bws.apigateway.rest.controller;

import com.bws.apigateway.api.request.*;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.CategoryListResponse;
import com.bws.apigateway.api.response.ProductGetResponse;
import com.bws.apigateway.api.response.ProductListResponse;
import com.bws.apigateway.model.constants.PropertyConstants;
import com.bws.apigateway.rest.controller.api.StockRestServiceApi;
import com.bws.apigateway.rest.servicecall.StockServiceCallImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(path = PropertyConstants.REQUEST_NOT_SECURE_SERVICE_STOCK_CONTROLLER)
@Slf4j
@RequiredArgsConstructor
@CrossOrigin

public class StockServiceController implements StockRestServiceApi {

    private final StockServiceCallImpl stockServiceCall;


    @Override
    public ResponseEntity<CategoryListResponse> getCategoryList(String categoryId, HttpServletRequest request){
        return ResponseEntity.ok(stockServiceCall.getCategoryListResponse(categoryId));
    }

    @Override
    public ResponseEntity<BaseResponse> addCategory(CategoryAddRequest categoryAddRequest, HttpServletRequest request) {
        return ResponseEntity.ok(stockServiceCall.addCategory(categoryAddRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> updateCategory(CategoryUpdateRequest categoryUpdateRequest, HttpServletRequest request) {
        return ResponseEntity.ok(stockServiceCall.updateCategory(categoryUpdateRequest));
    }

    @Override
    public ResponseEntity<ProductListResponse> getProductListByCategoryId(String categoryId, HttpServletRequest request){
        return ResponseEntity.ok(stockServiceCall.getProductListResponse(categoryId));
    }

    @Override
    public ResponseEntity<BaseResponse> addProduct(ProductAddRequest productAddRequest, HttpServletRequest request) {
        return ResponseEntity.ok(stockServiceCall.addProduct(productAddRequest));
    }

    @Override
    public ResponseEntity<ProductGetResponse> getProductByProductId(String productId, HttpServletRequest request){
        return ResponseEntity.ok(stockServiceCall.getProductByProductId(productId));
    }

    @Override
    public ResponseEntity<BaseResponse> updateProduct(ProductUpdateRequest productUpdateRequest, HttpServletRequest request) {
        return ResponseEntity.ok(stockServiceCall.updateProduct(productUpdateRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> addCompany(CompanyAddRequest companyAddRequest, HttpServletRequest request) {
        return ResponseEntity.ok(stockServiceCall.addCompany(companyAddRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> addComment(String productId, CommentAddRequest commentAddRequest, HttpServletRequest request) {
        return ResponseEntity.ok(stockServiceCall.addComment(productId,commentAddRequest));
    }




}
