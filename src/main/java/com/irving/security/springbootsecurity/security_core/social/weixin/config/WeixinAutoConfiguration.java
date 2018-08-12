package com.irving.security.springbootsecurity.security_core.social.weixin.config;

import com.irving.security.springbootsecurity.security_core.properties.SecurityProperties;
import com.irving.security.springbootsecurity.security_core.properties.WeixinProperties;
import com.irving.security.springbootsecurity.security_core.social.weixin.connect.WeixinConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;

/**
 * 微信登录配置
 */
@Configuration
@ConditionalOnProperty(prefix = "com.irving.security.social.weixin", name = "appId")
public class WeixinAutoConfiguration extends SocialConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * Default implementation of {@link #addConnectionFactories(ConnectionFactoryConfigurer, Environment)}.
     * Implemented as a no-op, adding no connection factories.
     *
     * @param connectionFactoryConfigurer
     * @param environment
     */
    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
        WeixinProperties weixinConfig = securityProperties.getSocialProperties().getWeixinProperties();
        WeixinConnectionFactory weixinConnectionFactory = new WeixinConnectionFactory(weixinConfig.getProviderId(), weixinConfig.getAppId(),
                weixinConfig.getAppSecret());
        connectionFactoryConfigurer.addConnectionFactory(weixinConnectionFactory);
    }
}
