package org.eheio.projet.iot.exception;

public class AuthenticationException extends org.springframework.security.core.AuthenticationException {
    public AuthenticationException(String msg) {
        super(msg);
    }
}
