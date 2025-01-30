package com.bws.apigateway.rest.servicecall.interfaces;

import com.bws.apigateway.model.entity.ErrorCodes;
import com.bws.apigateway.model.entity.MicroService;

import java.util.HashMap;

public interface ICacheService {

    HashMap<String, MicroService> microServiceList ();

    HashMap<String, ErrorCodes> getErrorCodesList();
}
