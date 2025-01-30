package com.bws.apigateway.rest.servicecall;

import com.bws.apigateway.api.client.MessageServiceClient;
import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.SendMessageRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.message.MessageListResponse;
import com.bws.apigateway.api.response.message.MessagesResponse;
import com.bws.apigateway.rest.servicecall.interfaces.IMessageServiceCall;
import com.bws.apigateway.rest.util.ServiceNameProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class MessageServiceCallImpl implements IMessageServiceCall, ServiceNameProvider {

    private final MessageServiceClient messageServiceClient;

    @Override
    public String getServiceName() {
        return "message-service";
    }

    @Override
    public MessageListResponse messageListResponse (String chatId,BaseRequest baseRequest){
        return messageServiceClient.messageListResponse(chatId,baseRequest);
    }

    @Override
    public MessagesResponse messagesResponse (String chatId , BaseRequest baseRequest){
        return messageServiceClient.messagesResponse(chatId,baseRequest);
    }

    @Override
    public BaseResponse sendMessage (SendMessageRequest sendMessageRequest){
        return messageServiceClient.sendMessage(sendMessageRequest);
    }

}
