package com.irving.security.springbootsecurity.security_core.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ImageCodeProperties {
    @Value("${com.irving.security.CAPTCHA.width:67}")
    private int width;

    @Value("${com.irving.security.CAPTCHA.height:32}")
    private int height;

    @Value("${com.irving.security.CAPTCHA.length:4}")
    private int length;

    @Value("${com.irving.security.CAPTCHA.expireIn:60}")
    private int expireIn;

    @Value("${com.irving.security.CAPTCHA.urls:/authentication/form}")
    private String urls;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

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

