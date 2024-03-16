package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.request.AddBalanceRequest;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.CreateOrderRequest;
import com.bws.apigateway.api.request.DeleteOrderByProductCodeRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.BuyOrdersOnCartTrackingNumberResponse;
import com.bws.apigateway.api.response.GetBalanceResponse;
import com.bws.apigateway.model.dto.OrderListDTO;
import com.bws.apigateway.model.entity.LogApiGateway;
import com.bws.apigateway.repository.LogApiGatewayRepository;
import com.bws.apigateway.rest.servicecall.interfaces.IIndexServiceCall;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.bws.apigateway.model.constants.PropertyConstants.*;

@Service
@Slf4j
@RequiredArgsConstructor

public class IndexServiceCallImpl implements IIndexServiceCall {

    private final RestTemplate restTemplate;

    private final LogApiGatewayRepository logApiGatewayRepository;

    @Value(REST_TEMPLATE_REQUEST_MICROSERVICE_PAYMENT_SERVICE_BALANCE_ADD)
    private String addBalanceFromPaymentServicePath;

    @Override
    public BaseResponse addBalanceServiceCall(AddBalanceRequest request) {
        logInDataBase("PaymentService",request.getClass().getName(),BaseResponse.class.getName());
        return restTemplate.postForObject(addBalanceFromPaymentServicePath, request, BaseResponse.class);
    }

    @Value(REST_TEMPLATE_REQUEST_MICROSERVICE_PAYMENT_SERVICE_BALANCE_GET)
    private String getBalancePathFromPaymentServicePath;

    @Override
    public GetBalanceResponse getBalanceServiceCall(BaseRequest request) {
        logInDataBase("PaymentService",request.getClass().getName(),GetBalanceResponse.class.getName());
        return restTemplate.postForObject(getBalancePathFromPaymentServicePath, request, GetBalanceResponse.class);
    }

    @Value(REST_TEMPLATE_REQUEST_MICROSERVICE_PRODUCT_SERVICE_ORDER_LIST_CREATE)
    private String createOrderListFromProductServicePath;

    public BaseResponse createOrderList(CreateOrderRequest request){
//        logInDataBase("ProductService",request.getClass().getName(),BuyProductWithCodeResponse.class.getName());
        return restTemplate.postForObject(createOrderListFromProductServicePath,request,BaseResponse.class);
    }

    @Value(REST_TEMPLATE_REQUEST_MICROSERVICE_PAYMENT_SERVICE_ORDERLIST_DELETEORDER)
    private String deleteOrderByProductCodeFromPaymentServicePath;

    public BaseResponse deleteOrderByProductCode (DeleteOrderByProductCodeRequest request){
        //        logInDataBase("ProductService",request.getClass().getName(),BuyProductWithCodeResponse.class.getName());
        return restTemplate.postForObject(deleteOrderByProductCodeFromPaymentServicePath,request,BaseResponse.class);
    }

    @Value(REST_TEMPLATE_REQUEST_MICROSERVICE_PAYMENT_SERVICE_ORDERLIST_GET)
    private String getOrderListFromPaymentServicePath;

    public List<OrderListDTO> getOrderList (BaseRequest request){
        //        logInDataBase("ProductService",request.getClass().getName(),BuyProductWithCodeResponse.class.getName());
        return restTemplate.postForObject(getOrderListFromPaymentServicePath,request, ArrayList.class);
    }


    public BuyOrdersOnCartTrackingNumberResponse buyOrdersOnCartsAndReturnTrackingNumber (BaseRequest request){
        return restTemplate.postForObject("http://localhost:8078/paymentservice/buyordersoncart",request, BuyOrdersOnCartTrackingNumberResponse.class);
    }


    private void logInDataBase(String serviceName,String baseRequest, String responseType){
        logApiGatewayRepository.save(LogApiGateway.builder().fetchedMicroservice(
                        serviceName)
                .requestType(baseRequest.substring(31,baseRequest.length()).toString())
                .error_code(0000L)
                .successfully(1)
                .responseType(responseType).build());
    }
}
