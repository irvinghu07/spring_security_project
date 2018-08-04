package com.irving.security.springbootsecurity.messaging;

public interface MessageCodeSender {
    void send(String cellPhoneNumber, String content);
}
