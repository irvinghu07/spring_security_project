package com.irving.security.springbootsecurity.validationCode.message;

public interface MessageCodeSender {
    void send(String cellPhoneNumber, String content);
}