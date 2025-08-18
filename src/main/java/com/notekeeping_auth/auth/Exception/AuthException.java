package com.notekeeping_auth.auth.Exception;

public class AuthException extends RuntimeException{

    public AuthException(String errorMessage) {
        super(errorMessage);
    }
}
