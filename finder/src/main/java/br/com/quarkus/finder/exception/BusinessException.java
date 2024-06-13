package br.com.quarkus.finder.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }

    public BusinessException(String code, Object...args){
    }
}