package com.irving.security.springbootsecurity.validationCode.message;

import com.irving.security.springbootsecurity.validationCode.ValidateCode;
import com.irving.security.springbootsecurity.validationCode.impl.AbstractValidateCodeProcessor;
import org.springframework.web.context.request.ServletWebRequest;

public class MessageCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) {

    }
}
