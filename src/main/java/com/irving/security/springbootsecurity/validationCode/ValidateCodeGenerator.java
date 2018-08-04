package com.irving.security.springbootsecurity.validationCode;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeGenerator {
    ValidateCode generateCode(ServletWebRequest request);
}
