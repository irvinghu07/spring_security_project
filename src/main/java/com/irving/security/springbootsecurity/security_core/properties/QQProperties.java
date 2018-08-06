package com.irving.security.springbootsecurity.security_core.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.social.SocialProperties;
import org.springframework.stereotype.Component;

@Component
public class QQProperties extends SocialProperties {

    @Value("${com.irving.security.social.qq.providerId:qq")
    private String providerId;

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
