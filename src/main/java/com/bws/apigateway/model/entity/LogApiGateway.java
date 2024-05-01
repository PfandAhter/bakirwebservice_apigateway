package com.bws.apigateway.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "log_api_gateway")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LogApiGateway {

    @Id
    @Column(name = "log_id")
    private String logId;

    @Column(name = "fetched_microservice")
    private String fetchedMicroservice;

    @Column(name = "request_type")
    private String requestType;

    @Column(name = "response_type")
    private String responseType;

    @Column(name = "successfully")
    private int successfully;

    @Column(name = "error_code")
    private Long error_code;

}
