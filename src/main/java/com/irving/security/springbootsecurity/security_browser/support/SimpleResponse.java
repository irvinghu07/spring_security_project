package com.irving.security.springbootsecurity.security_browser.support;

public class SimpleResponse {
    private String content;

    public SimpleResponse(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
