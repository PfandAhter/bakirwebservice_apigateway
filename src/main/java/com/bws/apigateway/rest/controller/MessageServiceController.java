package com.bws.apigateway.rest.controller;

import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.SendMessageRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.message.MessageListResponse;
import com.bws.apigateway.api.response.message.MessagesResponse;
import com.bws.apigateway.model.constants.PropertyConstants;
import com.bws.apigateway.rest.controller.api.MessageRestServiceApi;
import com.bws.apigateway.rest.servicecall.MessageServiceCallImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = PropertyConstants.REQUEST_SECURE_MESSAGE_SERVICE_CONTROLLER)
@RequiredArgsConstructor
@Slf4j

public class MessageServiceController implements MessageRestServiceApi {

    private final MessageServiceCallImpl messageServiceCall;

    @Override
    public ResponseEntity<MessageListResponse> messageListRequest (String chatId, BaseRequest baseRequest, HttpServletRequest request) {
        return ResponseEntity.ok(messageServiceCall.messageListResponse(chatId,baseRequest));
    }

    @Override
    public ResponseEntity<MessagesResponse> messagesRequest(String chatId, BaseRequest baseRequest, HttpServletRequest request) {
        return ResponseEntity.ok(messageServiceCall.messagesResponse(chatId,baseRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> sendMessageRequest(SendMessageRequest sendMessageRequest, HttpServletRequest request) {
        return ResponseEntity.ok(messageServiceCall.sendMessage(sendMessageRequest));
    }
}
