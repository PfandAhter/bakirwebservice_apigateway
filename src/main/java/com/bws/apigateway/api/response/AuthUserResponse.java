package com.bws.apigateway.api.response;

import com.bws.apigateway.model.Role;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AuthUserResponse{

    private String token;

    private Role role;
}
