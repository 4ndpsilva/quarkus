package br.com.quarkus.finder.exception;

public class CEPNotFoundException extends RuntimeException{
    public CEPNotFoundException(String msg){
        super(msg);
    }
}