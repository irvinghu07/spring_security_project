package com.irving.security.springbootsecurity.security_core.validationCode;

import com.irving.security.springbootsecurity.security_core.properties.SecurityProperties;
import com.irving.security.springbootsecurity.security_core.validationCode.image.ImageCodeGenerator;
import com.irving.security.springbootsecurity.security_core.validationCode.message.DefaultMessageCodeSender;
import com.irving.security.springbootsecurity.security_core.validationCode.message.MessageCodeSender;
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
