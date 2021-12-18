package org.eheio.projet.iot.exception;

import antlr.Token;

public class TokenNotValidException extends RuntimeException{

    public TokenNotValidException(String message){
        super(message);
    }
}
