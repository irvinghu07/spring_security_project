package com.irving.security.springbootsecurity.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Configuration
//@EnableConfigurationProperties(BrowserProperties.class)
public class SecurityProperties {
    @Autowired
    private BrowserProperties browserProperties;

    public BrowserProperties getBrowserProperties() {
        return browserProperties;
    }

    public void setBrowserProperties(BrowserProperties browserProperties) {
        this.browserProperties = browserProperties;
    }
}
