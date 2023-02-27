package com.dilmen.exception;

import lombok.Getter;

@Getter
public class WhoAmITriviaException extends RuntimeException{
    private final ErrorType errorType;

    public WhoAmITriviaException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType= errorType;
    }

    public WhoAmITriviaException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}
