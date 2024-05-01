package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.repository.ControllerPathsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j

public class GeneralServiceController {

    private final ControllerPathsRepository controllerPathsRepository;


}
