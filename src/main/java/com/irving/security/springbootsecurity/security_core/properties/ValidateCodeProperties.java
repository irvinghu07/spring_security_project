package com.irving.security.springbootsecurity.security_core.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateCodeProperties {
    @Autowired
    private ImageCodeProperties imageCodeProperties;

    @Autowired
    private MessageCodeProperties messageCodeProperties;

    public ImageCodeProperties getImageCodeProperties() {
        return imageCodeProperties;
    }

    public void setImageCodeProperties(ImageCodeProperties imageCodeProperties) {
        this.imageCodeProperties = imageCodeProperties;
    }

    public MessageCodeProperties getMessageCodeProperties() {
        return messageCodeProperties;
    }

    public void setMessageCodeProperties(MessageCodeProperties messageCodeProperties) {
        this.messageCodeProperties = messageCodeProperties;
    }
}
