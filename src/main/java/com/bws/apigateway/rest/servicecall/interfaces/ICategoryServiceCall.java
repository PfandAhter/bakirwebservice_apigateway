package com.bws.apigateway.rest.servicecall.interfaces;

import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.GetCategoryListRequest;
import com.bws.apigateway.model.dto.CategoryDTO;
import com.bws.apigateway.model.dto.ProductDTO;

import java.util.List;

public interface ICategoryServiceCall {
    List<CategoryDTO> getCategoryListResponse(BaseRequest request);

    List<ProductDTO> getProductListByCategoryName(GetCategoryListRequest request);
}
