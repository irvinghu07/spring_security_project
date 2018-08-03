package com.irving.security.springbootsecurity.generator;

import com.irving.security.springbootsecurity.CAPTCHA.ImageCode;
import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeGenerator {
    ImageCode createImageCode(ServletWebRequest request);
}
