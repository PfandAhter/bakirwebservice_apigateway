package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.client.MessageServiceClient;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.SendMessageRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.message.MessageListResponse;
import com.bws.apigateway.api.response.message.MessagesResponse;
import com.bws.apigateway.model.entity.LogApiGateway;
import com.bws.apigateway.repository.LogApiGatewayRepository;
import com.bws.apigateway.rest.servicecall.interfaces.IMessageServiceCall;
import com.bws.apigateway.rest.util.Util;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j

public class MessageServiceCallImpl implements IMessageServiceCall {

    private final MessageServiceClient messageServiceClient;

    private final LogApiGatewayRepository logApiGatewayRepository;

    private static final String serviceName = "message-service";

    @Override
    @Transactional
    public MessageListResponse messageListResponse (String chatId,BaseRequest baseRequest){
        logInDataBase(serviceName,BaseRequest.class.getName(),MessageListResponse.class.getName());
        return messageServiceClient.messageListResponse(chatId,baseRequest);
    }

    @Override
    @Transactional
    public MessagesResponse messagesResponse (String chatId , BaseRequest baseRequest){
        logInDataBase(serviceName,BaseRequest.class.getName(),MessagesResponse.class.getName());
        return messageServiceClient.messagesResponse(chatId,baseRequest);
    }


    @Override
    @Transactional
    public BaseResponse sendMessage (SendMessageRequest sendMessageRequest){
        logInDataBase(serviceName,SendMessageRequest.class.getName(),BaseResponse.class.getName());
        return messageServiceClient.sendMessage(sendMessageRequest);
    }

    @Transactional
    @Override
    public void logInDataBase(String serviceName,String baseRequest, String responseType){
        logApiGatewayRepository.save(LogApiGateway.builder().fetchedMicroservice(
                        serviceName)
                .logId(Util.generateCode())
                .requestType(baseRequest)
                .error_code(91000L)
                .successfully(1)
                .responseType(responseType).build());
    }
}
