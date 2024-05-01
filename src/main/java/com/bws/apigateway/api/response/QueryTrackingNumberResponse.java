package com.bws.apigateway.api.response;

import com.bws.apigateway.model.dto.OrderStatusDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class QueryTrackingNumberResponse {

    List<OrderStatusDTO> orderStatuses;

}
