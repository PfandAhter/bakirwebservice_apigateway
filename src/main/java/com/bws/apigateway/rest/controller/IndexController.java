package com.bws.apigateway.rest.controller;

import com.bws.apigateway.api.request.AddBalanceRequest;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.GetBalanceResponse;
import com.bws.apigateway.model.constants.PropertyConstants;
import com.bws.apigateway.rest.controller.api.IndexRestServiceApi;
import com.bws.apigateway.rest.servicecall.IndexServiceCallImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = PropertyConstants.REQUEST_LOCKED_INDEXSERVICE)
@CrossOrigin
@RequiredArgsConstructor

public class IndexController implements IndexRestServiceApi {

    private final IndexServiceCallImpl serviceCall;

    @Override
    public ResponseEntity<BaseResponse> addBalance(AddBalanceRequest addBalanceRequest, HttpServletRequest request, BindingResult bindingResult) {
        return ResponseEntity.ok(serviceCall.addBalanceServiceCall(addBalanceRequest));
    }

    @Override
    public ResponseEntity<GetBalanceResponse> getBalance(BaseRequest baseRequest, HttpServletRequest request, BindingResult bindingResult){
        return ResponseEntity.ok(serviceCall.getBalanceServiceCall(baseRequest));
    }
}
