package com.irving.security.springbootsecurity.security_core.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SocialProperties {

    @Value("${com.irving.security.social.processUrl:/auth}")
    private String processUrl;

    @Autowired
    private QQProperties qqProperties;

    @Autowired
    private WeixinProperties weixinProperties;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SocialProperties{");
        sb.append("processUrl='").append(processUrl).append('\'');
        sb.append(", qqProperties=").append(qqProperties);
        sb.append(", weixinProperties=").append(weixinProperties);
        sb.append('}');
        return sb.toString();
    }

    public WeixinProperties getWeixinProperties() {
        return weixinProperties;
    }

    public void setWeixinProperties(WeixinProperties weixinProperties) {
        this.weixinProperties = weixinProperties;
    }

    public QQProperties getQqProperties() {
        return qqProperties;
    }

    public void setQqProperties(QQProperties qqProperties) {
        this.qqProperties = qqProperties;
    }

    public String getProcessUrl() {
        return processUrl;
    }

    public void setProcessUrl(String processUrl) {
        this.processUrl = processUrl;
    }

}
