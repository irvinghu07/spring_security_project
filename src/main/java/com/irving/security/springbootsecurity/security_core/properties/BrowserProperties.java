package com.irving.security.springbootsecurity.security_core.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BrowserProperties {
    @Value("${com.irving.security.browser.signUpUrl:/security-signup.html}")
    private String signUpUrl;

    @Value("${com.irving.security.browser.loginPage:/security-login.html}")
    private String loginPage;

    @Value("${com.irving.security.browser.loginType:JSON}")
    private LoginType loginType;

    // default 24 hours
    @Value("${com.irving.security.browser.rememberMeDuration:86400}")
    private int rememberMeDuration;

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public int getRememberMeDuration() {
        return rememberMeDuration;
    }

    public void setRememberMeDuration(int rememberMeDuration) {
        this.rememberMeDuration = rememberMeDuration;
    }

    public String getSignUpUrl() {
        return signUpUrl;
    }

    public void setSignUpUrl(String signUpUrl) {
        this.signUpUrl = signUpUrl;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BrowserProperties{");
        sb.append("signUpUrl='").append(signUpUrl).append('\'');
        sb.append(", loginPage='").append(loginPage).append('\'');
        sb.append(", loginType=").append(loginType);
        sb.append(", rememberMeDuration=").append(rememberMeDuration);
        sb.append('}');
        return sb.toString();
    }
    
}
