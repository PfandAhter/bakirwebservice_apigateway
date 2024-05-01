package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.client.UserServiceClient;
import com.bws.apigateway.api.request.AddAddressInfoRequest;
import com.bws.apigateway.api.request.AddBalanceRequest;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.EmailValidatorRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.GetBalanceResponse;
import com.bws.apigateway.api.response.SellerGetResponse;
import com.bws.apigateway.model.entity.LogApiGateway;
import com.bws.apigateway.repository.LogApiGatewayRepository;
import com.bws.apigateway.rest.servicecall.interfaces.IUserServiceCall;
import com.bws.apigateway.rest.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor

public class UserServiceCallImpl implements IUserServiceCall {

    private final UserServiceClient userServiceClient;

    private final LogApiGatewayRepository logApiGatewayRepository;

    @Override
    public GetBalanceResponse getBalanceRequest (BaseRequest request){
        logInDataBase(BaseRequest.class.getName(),GetBalanceResponse.class.getName());
        return userServiceClient.getBalanceRequest(request);
    }

    @Override
    public BaseResponse addBalanceRequest (AddBalanceRequest request){
        logInDataBase(AddBalanceRequest.class.getName(),BaseResponse.class.getName());
        return userServiceClient.addBalanceRequest(request);
    }

    //TODO CHECK THAT IS IT WORKING ...
    public BaseResponse addAddressInfo(AddAddressInfoRequest request){
        //logtodatabase
        return userServiceClient.addAddressInfo(request);
    }

    public BaseResponse emailValidate (EmailValidatorRequest request){
        //logtodatabase
        return userServiceClient.emailValidate(request);
    }

    public BaseResponse activateSellerByAdmin (String sellerid , BaseRequest baseRequest){
        //log to database
        return userServiceClient.activateSellerByAdmin(sellerid,baseRequest);
    }

    public SellerGetResponse getSellers (String sellerId ,BaseRequest baseRequest){
        //log to database
        return userServiceClient.getSellers(sellerId , baseRequest);
    }

    private void logInDataBase(String requestType, String responseType){
        logApiGatewayRepository.save(LogApiGateway.builder().fetchedMicroservice(
                        "UserService")
                .logId(Util.generateCode())
                .requestType(requestType)
                .error_code(0000L)
                .successfully(1)
                .responseType(responseType).build());
    }
}
