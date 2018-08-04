package com.irving.security.springbootsecurity.validationCode.message;

import com.irving.security.springbootsecurity.validationCode.ValidateCode;
import com.irving.security.springbootsecurity.validationCode.impl.AbstractValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

@Component("messageCodeProcessor")
public class MessageCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

    @Autowired
    private MessageCodeSender sender;

    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        sender.send(ServletRequestUtils.getStringParameter(request.getRequest(), "mobile"), validateCode.getCode());
    }
}
