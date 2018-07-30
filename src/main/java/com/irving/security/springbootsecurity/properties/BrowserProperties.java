package com.irving.security.springbootsecurity.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BrowserProperties {
    @Value("${com.irving.security.browser.loginPage:/security-login.html}")
    private String loginPage;

    @Value("${com.irving.security.browser.loginType:JSON}")
    private LoginType loginType;

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
}
