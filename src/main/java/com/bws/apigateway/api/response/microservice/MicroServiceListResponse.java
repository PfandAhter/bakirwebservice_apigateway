package com.bws.apigateway.api.response.microservice;

import com.bws.apigateway.model.entity.MicroService;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class MicroServiceListResponse {

    List<MicroService> microServiceList;
}