package com.irving.security.springbootsecurity.security_core.validationCode;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeGenerator {
    ValidateCode generateCode(ServletWebRequest request);
}
