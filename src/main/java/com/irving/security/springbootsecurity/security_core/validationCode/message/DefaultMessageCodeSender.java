package com.irving.security.springbootsecurity.security_core.validationCode.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultMessageCodeSender implements MessageCodeSender {
    private static final Logger logger = LoggerFactory.getLogger(DefaultMessageCodeSender.class);

    @Override
    public void send(String cellPhoneNumber, String content) {
        logger.info(String.format("sending message to cell phone number:%s with content: %s", cellPhoneNumber, content));
    }
}
