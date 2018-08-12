package com.irving.security.springbootsecurity.security_core.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecurityProperties {

    @Autowired
    private SocialProperties socialProperties;

    @Autowired
    private BrowserProperties browserProperties;

    @Autowired
    private ValidateCodeProperties validateCodeProperties;

    public BrowserProperties getBrowserProperties() {
        return browserProperties;
    }

    public void setBrowserProperties(BrowserProperties browserProperties) {
        this.browserProperties = browserProperties;
    }

    public ValidateCodeProperties getValidateCodeProperties() {
        return validateCodeProperties;
    }

    public void setValidateCodeProperties(ValidateCodeProperties validateCodeProperties) {
        this.validateCodeProperties = validateCodeProperties;
    }

    public SocialProperties getSocialProperties() {
        return socialProperties;
    }

    public void setSocialProperties(SocialProperties socialProperties) {
        this.socialProperties = socialProperties;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SecurityProperties{");
        sb.append("socialProperties=").append(socialProperties);
        sb.append(", browserProperties=").append(browserProperties);
        sb.append(", validateCodeProperties=").append(validateCodeProperties);
        sb.append('}');
        return sb.toString();
    }
}
