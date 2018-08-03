package com.irving.security.springbootsecurity.CAPTCHA;

import com.irving.security.springbootsecurity.generator.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

//@Component("CAPTCHAGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode createImageCode(ServletWebRequest request) {
        System.out.println("advanced CAPTCHA generator");
        return null;
    }
}
