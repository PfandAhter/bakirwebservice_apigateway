package com.bws.apigateway.exceptions;

import lombok.Getter;

public class ResourceAccessException extends Exception{

    @Getter
    private String message;

    public ResourceAccessException(){
        super();
        this.message = null;
    }
    public ResourceAccessException(String message){
        super();
        this.message = message;
    }

}
