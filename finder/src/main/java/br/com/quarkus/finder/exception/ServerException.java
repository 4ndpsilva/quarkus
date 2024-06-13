package br.com.quarkus.finder.exception;

public class ServerException extends RuntimeException{
    public ServerException(Exception ex){
        super(ex);
    }
}