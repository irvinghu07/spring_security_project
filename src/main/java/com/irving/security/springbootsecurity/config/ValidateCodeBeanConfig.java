package com.irving.security.springbootsecurity.config;

import com.irving.security.springbootsecurity.validationCode.image.ImageCodeGenerator;
import com.irving.security.springbootsecurity.validationCode.ValidateCodeGenerator;
import com.irving.security.springbootsecurity.messaging.DefaultMessageCodeSender;
import com.irving.security.springbootsecurity.messaging.MessageCodeSender;
import com.irving.security.springbootsecurity.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidateCodeBeanConfig {
    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(name = "CAPTCHAGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(MessageCodeSender.class)
    public MessageCodeSender messageCodeSender() {
        return new DefaultMessageCodeSender();
    }
}
