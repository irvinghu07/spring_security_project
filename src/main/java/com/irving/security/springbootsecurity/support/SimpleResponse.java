package com.irving.security.springbootsecurity.support;

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
