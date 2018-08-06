package com.irving.security.springbootsecurity.security_core.validationCode.message;

public interface MessageCodeSender {
    void send(String cellPhoneNumber, String content);
}
