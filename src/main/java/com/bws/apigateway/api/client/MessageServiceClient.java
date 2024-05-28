package com.bws.apigateway.api.client;


import com.bws.apigateway.api.request.BaseRequest;
import com.bws.apigateway.api.request.SendMessageRequest;
import com.bws.apigateway.api.response.BaseResponse;
import com.bws.apigateway.api.response.message.MessageListResponse;
import com.bws.apigateway.api.response.message.MessagesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "MessageService", url = "${client.feign.message-service.path}")
public interface MessageServiceClient {

    @PostMapping("${client.feign.message-service.messageList}")
    MessageListResponse messageListResponse (@RequestParam ("chatid") String chatId, @RequestBody BaseRequest baseRequest);

    @PostMapping("${client.feign.message-service.messages}")
    MessagesResponse messagesResponse (@RequestParam("chatid") String chatId, @RequestBody BaseRequest baseRequest);

    @PostMapping("${client.feign.message-service.sendMessage}")
    BaseResponse sendMessage (@RequestBody SendMessageRequest sendMessageRequest);
}
