package com.projeto.curosFinalizado.serviços.exceptions;

public class DataBaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DataBaseException(String menssagem){
        super(menssagem);
    }
}
