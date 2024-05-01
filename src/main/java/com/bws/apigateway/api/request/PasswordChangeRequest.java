package com.bws.apigateway.api.request;

import com.bws.apigateway.model.constants.ErrorCodeConstants;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PasswordChangeRequest extends BaseRequest {

    @NotEmpty(message = ErrorCodeConstants.PASSWORD_NOT_NULL)
    private String oldPassword;

    @NotEmpty(message = ErrorCodeConstants.PASSWORD_NOT_NULL)
    private String newPassword;

    @NotEmpty(message = ErrorCodeConstants.PASSWORD_NOT_NULL)
    private String newPasswordAgain;

}
