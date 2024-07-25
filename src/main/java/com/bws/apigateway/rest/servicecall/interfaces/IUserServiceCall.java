package com.bws.apigateway.rest.servicecall.interfaces;

import com.bws.apigateway.api.request.AddAddressInfoRequest;
import com.bws.apigateway.api.request.AddBalanceRequest;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.EmailValidatorRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.GetBalanceResponse;
import com.bws.apigateway.api.response.SellerGetResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IUserServiceCall {
    GetBalanceResponse getBalanceRequest (BaseRequest request);

    BaseResponse addBalanceRequest (AddBalanceRequest request);

    BaseResponse addAddressInfo(AddAddressInfoRequest request);

    BaseResponse emailValidate (EmailValidatorRequest request);

    BaseResponse activateSellerByAdmin (String sellerId , BaseRequest baseRequest);

    SellerGetResponse getSellers (String sellerId , BaseRequest baseRequest);

    BaseResponse addPhoto (MultipartFile image , BaseRequest baseRequest);

    byte[] getPhoto (BaseRequest baseRequest);

}
