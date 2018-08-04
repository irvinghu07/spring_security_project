package com.irving.security.springbootsecurity.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageCodeProperties {

    @Value("${com.irving.security.message.length:6}")
    private int length;

    @Value("${com.irving.security.message.expireIn:60}")
    private int expireIn;

    @Value("${com.irving.security.message.urls:/authentication/form}")
    private String urls;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }
}

