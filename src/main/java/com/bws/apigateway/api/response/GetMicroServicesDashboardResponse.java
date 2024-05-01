package com.bws.apigateway.api.response;

import com.bws.apigateway.model.dto.MicroServicesDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class GetMicroServicesDashboardResponse {
    List<MicroServicesDTO> microServicesDTOList;
}
