package com.bws.apigateway.rest.controller.api;

import com.bws.apigateway.api.request.*;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.CategoryListResponse;
import com.bws.apigateway.api.response.ProductGetResponse;
import com.bws.apigateway.api.response.ProductListResponse;
import com.bws.apigateway.model.constants.PropertyConstants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface StockRestServiceApi {

    @GetMapping(path = PropertyConstants.REQUEST_NOT_SECURE_REST_CONTROLLER_STOCK_SERVICE_CATEGORY_LIST_GET)
    ResponseEntity<CategoryListResponse> getCategoryList (@RequestParam("category") String categoryId, HttpServletRequest request);

    @PostMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_STOCK_SERVICE_CATEGORY_ADD, produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> addCategory (@Valid @RequestBody CategoryAddRequest categoryAddRequest , HttpServletRequest request);

    @PostMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_STOCK_SERVICE_CATEGORY_UPDATE, produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> updateCategory (@Valid @RequestBody CategoryUpdateRequest categoryUpdateRequest , HttpServletRequest request);

    @GetMapping(path = PropertyConstants.REQUEST_NOT_SECURE_REST_CONTROLLER_STOCK_SERVICE_PRODUCT_LIST_GET)
    ResponseEntity<ProductListResponse> getProductListByCategoryId(@Valid @RequestParam("category") String categoryId, HttpServletRequest request);

    @PostMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_STOCK_SERVICE_PRODUCT_ADD , produces = MediaType.APPLICATION_JSON_VALUE,  consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> addProduct (@Valid @RequestBody ProductAddRequest productAddRequest , HttpServletRequest request);

    @GetMapping(path = PropertyConstants.REQUEST_NOT_SECURE_REST_CONTROLLER_STOCK_SERVICE_GET_PRODUCT_BY_PRODUCT_CODE)
    ResponseEntity<ProductGetResponse> getProductByProductId(@RequestParam("product") String productId , HttpServletRequest request);

    @PostMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_STOCK_SERVICE_PRODUCT_UPDATE , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> updateProduct (@Valid @RequestBody ProductUpdateRequest productUpdateRequest , HttpServletRequest request);

    @PostMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_STOCK_SERVICE_COMPANY_ADD ,produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> addCompany (@Valid @RequestBody CompanyAddRequest companyAddRequest , HttpServletRequest request);


}

