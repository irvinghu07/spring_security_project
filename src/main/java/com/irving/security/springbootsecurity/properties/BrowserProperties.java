package com.irving.security.springbootsecurity.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Configuration
@Component
public class BrowserProperties {
//    com.irving.security.browser.
    @Value("${loginPage:/security-login.html}")
    private String loginPage;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
