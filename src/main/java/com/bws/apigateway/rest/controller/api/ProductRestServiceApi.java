package com.bws.apigateway.rest.controller.api;

import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.GetCategoryListRequest;
import com.bws.apigateway.exceptions.ServiceUnavailableException;
import com.bws.apigateway.model.constants.PropertyConstants;
import com.bws.apigateway.model.dto.CategoryDTO;
import com.bws.apigateway.model.dto.ProductDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

public interface ProductRestServiceApi {

    @PostMapping(path = PropertyConstants.REQUEST_PRODUCT_PRODUCTLIST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ProductDTO>> getProductList (@Valid @RequestBody BaseRequest baseRequest, HttpServletRequest request, BindingResult bindingResult);

    @PostMapping(path = PropertyConstants.REQUEST_PRODUCT_PRODUCTLISTBYCATEGORYNAME,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ProductDTO>> getProductlistByCategoryName (@Valid @RequestBody GetCategoryListRequest getCategoryListRequest, HttpServletRequest request, BindingResult bindingResult);

    @PostMapping(path = PropertyConstants.REQUEST_CATEGORY_CATEGORYLIST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CategoryDTO>> getCategoryList (@Valid @RequestBody BaseRequest baseRequest, HttpServletRequest request, BindingResult bindingResult);

}
