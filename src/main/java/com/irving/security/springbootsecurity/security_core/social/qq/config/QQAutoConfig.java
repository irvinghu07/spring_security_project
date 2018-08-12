package com.irving.security.springbootsecurity.security_core.social.qq.config;

import com.irving.security.springbootsecurity.security_core.properties.QQProperties;
import com.irving.security.springbootsecurity.security_core.properties.SecurityProperties;
import com.irving.security.springbootsecurity.security_core.social.qq.connect.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;

@Configuration
@ConditionalOnProperty(prefix = "com.irving.security.social.qq", name = "appId")
public class QQAutoConfig extends SocialConfigurerAdapter {

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
        QQProperties qqProperties = securityProperties.getSocialProperties().getQqProperties();
        QQConnectionFactory qqConnectionFactory = new QQConnectionFactory(qqProperties.getProviderId(), qqProperties.getAppId(), qqProperties.getAppSecret());
        connectionFactoryConfigurer.addConnectionFactory(qqConnectionFactory);

    }

}
