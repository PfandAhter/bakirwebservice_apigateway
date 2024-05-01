package com.bws.apigateway.rest.controller;

import com.bws.apigateway.api.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@CrossOrigin
@RequiredArgsConstructor
@Slf4j

public class GeneralController {


    @PostMapping("{path}")
    ResponseEntity<BaseResponse> testApiGw(@PathVariable String path){
        path.split("/");
        return null;
    }


}
