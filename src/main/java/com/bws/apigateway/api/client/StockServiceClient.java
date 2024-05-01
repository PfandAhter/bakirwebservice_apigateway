package com.bws.apigateway.api.client;

import com.bws.apigateway.api.request.*;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.CategoryListResponse;
import com.bws.apigateway.api.response.ProductGetResponse;
import com.bws.apigateway.api.response.ProductListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "StockService", url = "${client.feign.stock-service.path}")
public interface StockServiceClient {

    @GetMapping("${client.feign.stock-service.category.listCategory}")
    CategoryListResponse listCategoryRequest (@RequestParam("category") String categoryId);

    @PostMapping("${client.feign.stock-service.category.addCategory}")
    BaseResponse addCategoryRequest (@RequestBody CategoryAddRequest categoryAddRequest);

    @PostMapping("${client.feign.stock-service.category.updateCategory}")
    BaseResponse updateCategoryRequest(@RequestBody CategoryUpdateRequest categoryUpdateRequest);

    @GetMapping("${client.feign.stock-service.product.listProduct}")
    ProductListResponse listProductByCategoryIdRequest(@RequestParam("category") String categoryId);

    @PostMapping("${client.feign.stock-service.product.addProduct}")
    BaseResponse addProductRequest (@RequestBody ProductAddRequest productAddRequest);

    @PostMapping("${client.feign.stock-service.product.updateProduct}")
    BaseResponse updateProductRequest(@RequestBody ProductUpdateRequest productUpdateRequest);

    @GetMapping("${client.feign.stock-service.product.getProduct}")
    ProductGetResponse getProduct (@RequestParam ("product") String productId);

    @PostMapping("${client.feign.stock-service.company.addCompany}")
    BaseResponse addCompany (@RequestBody CompanyAddRequest companyAddRequest);

}
