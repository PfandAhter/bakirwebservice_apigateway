package com.bws.apigateway.rest.controller.api;

import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.SendMessageRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.message.MessageListResponse;
import com.bws.apigateway.api.response.message.MessagesResponse;
import com.bws.apigateway.model.constants.PropertyConstants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface MessageRestServiceApi {

    @GetMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_MESSAGE_SERVICE_MESSAGE_LIST)
    ResponseEntity<MessageListResponse> messageListRequest(@RequestParam("chatid") String chatId, BaseRequest baseRequest, HttpServletRequest request);

    @GetMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_MESSAGE_SERVICE_MESSAGES)
    ResponseEntity<MessagesResponse> messagesRequest(@RequestParam("chatid") String chatId, BaseRequest baseRequest, HttpServletRequest request);

    @PostMapping(path = PropertyConstants.REQUEST_SECURE_REST_CONTROLLER_MESSAGE_SERVICE_SEND_MESSAGE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> sendMessageRequest(@Valid @RequestBody SendMessageRequest sendMessageRequest , HttpServletRequest request);

}