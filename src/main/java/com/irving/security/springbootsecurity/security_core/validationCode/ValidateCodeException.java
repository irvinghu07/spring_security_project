package com.irving.security.springbootsecurity.security_core.validationCode;

import org.springframework.security.core.AuthenticationException;

public class ValidateCodeException extends AuthenticationException{
    public ValidateCodeException(String msg) {
        super(msg);
    }
}
