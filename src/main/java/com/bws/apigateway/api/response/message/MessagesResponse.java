package com.bws.apigateway.api.response.message;

import com.bws.apigateway.model.dto.MessageDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class MessagesResponse {
    List<MessageDTO> messageList;
}
