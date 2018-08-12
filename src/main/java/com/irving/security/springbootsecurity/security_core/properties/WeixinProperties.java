package com.irving.security.springbootsecurity.security_core.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeixinProperties {
    @Value("${com.irving.security.social.weixin.providerId:weixin}")
    private String providerId;

    /**
     * Application id.
     */
    @Value("${com.irving.security.social.weixin.appId}")
    private String appId;

    /**
     * Application secret.
     */
    @Value("${com.irving.security.social.weixin.appSecret}")
    private String appSecret;

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WeixinProperties{");
        sb.append("providerId='").append(providerId).append('\'');
        sb.append(", appId='").append(appId).append('\'');
        sb.append(", appSecret='").append(appSecret).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
