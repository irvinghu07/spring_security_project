package com.irving.security.springbootsecurity.CAPTCHA;

import com.irving.security.springbootsecurity.validationCode.ValidateCode;
import com.irving.security.springbootsecurity.validationCode.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

//@Component("CAPTCHAGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ValidateCode generateCode(ServletWebRequest request) {
        System.out.println("advanced CAPTCHA generator");
        return null;
    }
}
