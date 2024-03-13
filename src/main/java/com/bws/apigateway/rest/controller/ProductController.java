package com.bws.apigateway.rest.controller;

import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.GetCategoryListRequest;
import com.bws.apigateway.model.constants.PropertyConstants;
import com.bws.apigateway.model.dto.CategoryDTO;
import com.bws.apigateway.model.dto.ProductDTO;
import com.bws.apigateway.rest.controller.api.ProductRestServiceApi;
import com.bws.apigateway.rest.servicecall.CategoryServiceCallImpl;
import com.bws.apigateway.rest.servicecall.ProductServiceCallImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = PropertyConstants.REQUEST_NOTLOCKED_PRODUCTSERVICE)
//TODO BURAYA BI BAK IKI TANE AYNI UCU KULLANABILIYORMUYUZ DIYE ...
@Slf4j
@RequiredArgsConstructor

public class ProductController implements ProductRestServiceApi {

    private final ProductServiceCallImpl productServiceCall;

    private final CategoryServiceCallImpl categoryServiceCall;

    @Override
    public ResponseEntity<List<ProductDTO>> getProductList(BaseRequest baseRequest, HttpServletRequest request, BindingResult bindingResult){
        return ResponseEntity.ok(productServiceCall.getProductListResponse(baseRequest));
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getProductlistByCategoryName(GetCategoryListRequest getCategoryListRequest, HttpServletRequest request, BindingResult bindingResult){
        return ResponseEntity.ok(categoryServiceCall.getProductListByCategoryName(getCategoryListRequest));
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> getCategoryList(BaseRequest baseRequest, HttpServletRequest request, BindingResult bindingResult){
        return ResponseEntity.ok(categoryServiceCall.getCategoryListResponse(baseRequest));
    }
}
