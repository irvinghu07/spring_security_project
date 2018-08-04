package com.irving.security.springbootsecurity.CAPTCHA;

import com.irving.security.springbootsecurity.validationCode.ValidateCodeGenerator;
import com.irving.security.springbootsecurity.validationCode.image.ImageCode;
import org.springframework.web.context.request.ServletWebRequest;

//@Component("CAPTCHAGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generateCode(ServletWebRequest request) {
        System.out.println("advanced CAPTCHA generator");
        return null;
    }
}
