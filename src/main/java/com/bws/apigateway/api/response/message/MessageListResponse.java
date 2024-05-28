package com.bws.apigateway.api.response.message;

import com.bws.apigateway.model.dto.MessageListDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class MessageListResponse {
    List<MessageListDTO> messageDTOList;
}
