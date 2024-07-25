package com.bws.apigateway.rest.servicecall.interfaces;

import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.SendMessageRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.message.MessageListResponse;
import com.bws.apigateway.api.response.message.MessagesResponse;

public interface IMessageServiceCall {

    MessageListResponse messageListResponse (String chatId, BaseRequest baseRequest);

    MessagesResponse messagesResponse (String chatId , BaseRequest baseRequest);

    BaseResponse sendMessage (SendMessageRequest sendMessageRequest);

}
