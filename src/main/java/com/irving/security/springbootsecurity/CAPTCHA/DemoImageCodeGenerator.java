package com.irving.security.springbootsecurity.CAPTCHA;

import com.irving.security.springbootsecurity.security_core.validationCode.ValidateCode;
import com.irving.security.springbootsecurity.security_core.validationCode.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

//@Component("CAPTCHAGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ValidateCode generateCode(ServletWebRequest request) {
        System.out.println("advanced CAPTCHA generator");
        return null;
    }
}
