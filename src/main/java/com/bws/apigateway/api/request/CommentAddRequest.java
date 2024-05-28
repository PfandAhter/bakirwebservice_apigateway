package com.bws.apigateway.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CommentAddRequest extends BaseRequest{

    private String comment;
}
