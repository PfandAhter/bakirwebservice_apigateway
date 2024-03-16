package com.bws.apigateway.repository;

import com.bws.apigateway.model.entity.LogApiGateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogApiGatewayRepository extends JpaRepository<LogApiGateway,Long> {

    LogApiGateway findLogApiGatewayByFetchedMicroservice (String fetchedMicroserviceName);
}
