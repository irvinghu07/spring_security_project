package com.irving.security.springbootsecurity.validationCode.impl;

import com.irving.security.springbootsecurity.validationCode.ValidateCodeGenerator;
import com.irving.security.springbootsecurity.validationCode.ValidateCode;
import com.irving.security.springbootsecurity.validationCode.ValidateCodeProcessor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerators;

    @Override
    public void create(ServletWebRequest request) throws Exception {
        C validateCode = generate(request);
        save(request, validateCode);
        send(request, validateCode);
    }

    protected abstract void send(ServletWebRequest request, C validateCode);

    private void save(ServletWebRequest request, C validateCode) {
        sessionStrategy.setAttribute(request, SESSION_KEY_PREFIX
                .append(getProcessorType(request).toUpperCase()).toString(), validateCode);
    }

    private C generate(ServletWebRequest request) {
        StringBuffer type = new StringBuffer(getProcessorType(request));
        ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(type.append("CodeGenerator").toString());
        return (C) validateCodeGenerator.generateCode(request);
    }

    private String getProcessorType(ServletWebRequest request) {
        return StringUtils.substringAfter(request.getRequest().getRequestURI(), "/code/");
    }


}
