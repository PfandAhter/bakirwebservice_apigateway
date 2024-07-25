package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.client.TokenServiceClient;
import com.bws.apigateway.api.client.UserServiceClient;
import com.bws.apigateway.api.request.*;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.GetBalanceResponse;
import com.bws.apigateway.api.response.SellerGetResponse;
import com.bws.apigateway.model.entity.LogApiGateway;
import com.bws.apigateway.repository.LogApiGatewayRepository;
import com.bws.apigateway.rest.servicecall.interfaces.IUserServiceCall;
import com.bws.apigateway.rest.util.ServiceNameProvider;
import com.bws.apigateway.rest.util.Util;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor

public class UserServiceCallImpl implements IUserServiceCall, ServiceNameProvider {

    private final UserServiceClient userServiceClient;

    private final TokenServiceClient tokenServiceClient;

    @Override
    public String getServiceName() {
        return "user-service";
    }

    @Override
    public GetBalanceResponse getBalanceRequest (BaseRequest request){
        return userServiceClient.getBalanceRequest(request);
    }

    @Override
    public BaseResponse addBalanceRequest (AddBalanceRequest request){
        return userServiceClient.addBalanceRequest(request);
    }
    //TODO CHECK THAT IS IT WORKING ...

    @Override
    public BaseResponse addAddressInfo(AddAddressInfoRequest request){
        return userServiceClient.addAddressInfo(request);
    }

    @Override
    public BaseResponse emailValidate (EmailValidatorRequest request){
        return userServiceClient.emailValidate(request);
    }

    @Override
    public BaseResponse activateSellerByAdmin (String sellerId , BaseRequest baseRequest){
        return userServiceClient.activateSellerByAdmin(sellerId,baseRequest);
    }

    @Override
    public SellerGetResponse getSellers (String sellerId ,BaseRequest baseRequest){
        return userServiceClient.getSellers(sellerId , baseRequest);
    }

    @Override
    public BaseResponse addPhoto (MultipartFile image , BaseRequest baseRequest){

        String localUsername = tokenServiceClient.extractedUsername(baseRequest);

        image.getName();
        AddPhotoRequest addPhotoRequest = new AddPhotoRequest();
        addPhotoRequest.setPhoto(image);

        return userServiceClient.addPhoto(localUsername,image);
    }

    @Override
    public byte[] getPhoto (BaseRequest baseRequest){
        return userServiceClient.getPhoto(baseRequest);
    }
}
