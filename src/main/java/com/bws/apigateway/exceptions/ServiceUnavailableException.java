package com.bws.apigateway.exceptions;


import lombok.Getter;

public class ServiceUnavailableException extends javax.naming.ServiceUnavailableException {

    @Getter
    private String message;

    public ServiceUnavailableException(){
        super();
        this.message = null;
    }

    public ServiceUnavailableException (String message){
        super();
        this.message = message;
    }
}
