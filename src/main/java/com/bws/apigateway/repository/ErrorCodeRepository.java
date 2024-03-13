package com.bws.apigateway.repository;

import com.bws.apigateway.model.entity.ErrorCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorCodeRepository extends JpaRepository<ErrorCodes,Long> {
    ErrorCodes findErrorByError (String errorCode);

}
