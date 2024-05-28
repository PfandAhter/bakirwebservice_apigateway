package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.client.UserServiceClient;
import com.bws.apigateway.api.request.*;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.GetBalanceResponse;
import com.bws.apigateway.api.response.SellerGetResponse;
import com.bws.apigateway.model.entity.LogApiGateway;
import com.bws.apigateway.repository.LogApiGatewayRepository;
import com.bws.apigateway.rest.servicecall.interfaces.IUserServiceCall;
import com.bws.apigateway.rest.util.Util;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@RequiredArgsConstructor

public class UserServiceCallImpl implements IUserServiceCall {

    private final UserServiceClient userServiceClient;

    private final LogApiGatewayRepository logApiGatewayRepository;



    private static final String serviceName = "user-service";

    @Override
    @Transactional
    public GetBalanceResponse getBalanceRequest (BaseRequest request){
        logInDataBase(BaseRequest.class.getName(),GetBalanceResponse.class.getName());
        return userServiceClient.getBalanceRequest(request);
    }

    @Override
    @Transactional
    public BaseResponse addBalanceRequest (AddBalanceRequest request){
        logInDataBase(AddBalanceRequest.class.getName(),BaseResponse.class.getName());
        return userServiceClient.addBalanceRequest(request);
    }

    //TODO CHECK THAT IS IT WORKING ...
    @Override
    @Transactional
    public BaseResponse addAddressInfo(AddAddressInfoRequest request){
        logInDataBase(AddAddressInfoRequest.class.getName(),BaseResponse.class.getName());
        return userServiceClient.addAddressInfo(request);
    }

    @Override
    @Transactional
    public BaseResponse emailValidate (EmailValidatorRequest request){
        logInDataBase(EmailValidatorRequest.class.getName(),BaseResponse.class.getName());
        return userServiceClient.emailValidate(request);
    }

    @Override
    @Transactional
    public BaseResponse activateSellerByAdmin (String sellerId , BaseRequest baseRequest){
        logInDataBase(BaseRequest.class.getName(),BaseResponse.class.getName());
        return userServiceClient.activateSellerByAdmin(sellerId,baseRequest);
    }

    @Override
    @Transactional
    public SellerGetResponse getSellers (String sellerId ,BaseRequest baseRequest){
        logInDataBase(BaseRequest.class.getName(),SellerGetResponse.class.getName());
        return userServiceClient.getSellers(sellerId , baseRequest);
    }

    public BaseResponse addPhoto (MultipartFile image , BaseRequest baseRequest){

        image.getName();
        //log to database
        AddPhotoRequest addPhotoRequest = new AddPhotoRequest();
        addPhotoRequest.setPhoto(image);

        return userServiceClient.addPhoto("Pfand",image);
    }

    public byte[] getPhoto (BaseRequest baseRequest){
        //log to database
        return userServiceClient.getPhoto(baseRequest);
    }

    @Transactional
    @Override
    public void logInDataBase(String requestType, String responseType){
        logApiGatewayRepository.save(LogApiGateway.builder().fetchedMicroservice(
                        serviceName)
                .logId(Util.generateCode())
                .requestType(requestType)
                .error_code(6000L)
                .successfully(1)
                .responseType(responseType).build());
    }
}
