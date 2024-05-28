package com.bws.apigateway.api.client;

import com.bws.apigateway.api.request.*;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.GetBalanceResponse;
import com.bws.apigateway.api.response.SellerGetResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "UserService", url = "${client.feign.user-service.path}")
public interface UserServiceClient {

    @PostMapping("${client.feign.user-service.addBalance}")
    BaseResponse addBalanceRequest(@RequestBody AddBalanceRequest addBalanceRequest);

    @PostMapping("${client.feign.user-service.getBalance}")
    GetBalanceResponse getBalanceRequest (@RequestBody BaseRequest getBalanceRequest);

    @PostMapping("${client.feign.user-service.addAddressInfo}")
    BaseResponse addAddressInfo(@RequestBody AddAddressInfoRequest addAddressInfoRequest);

    @PostMapping("${client.feign.user-service.emailValidate}")
    BaseResponse emailValidate(@RequestBody EmailValidatorRequest emailValidatorRequest);

    @PostMapping("${client.feign.user-service.activateSellerByAdmin}")
    BaseResponse activateSellerByAdmin (@RequestParam("sellerid") String sellerId, @RequestBody BaseRequest baseRequest);

    @PostMapping("${client.feign.user-service.getSellers}")
    SellerGetResponse getSellers (@RequestParam("sellers") String sellers , @RequestBody BaseRequest baseRequest);

//    @PostMapping(value = "${client.feign.user-service.addPhoto}" )
//    BaseResponse addPhoto (MultipartFile image, @RequestBody BaseRequest baseRequest);

//    @RequestLine("POST /photo/add")
//    @Headers({"Content-Type: multipart/form-data"})
    @PostMapping(value = "${client.feign.user-service.addPhoto}" , consumes = {"multipart/form-data"})
    BaseResponse addPhoto(@RequestPart("user") String userName , @RequestPart("image") MultipartFile image);

    @PostMapping("${client.feign.user-service.getPhoto}")
    byte[] getPhoto (@RequestBody BaseRequest baseRequest);

}
