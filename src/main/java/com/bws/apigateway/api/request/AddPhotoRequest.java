package com.bws.apigateway.api.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter

public class AddPhotoRequest extends BaseRequest{

    private MultipartFile photo;
}
