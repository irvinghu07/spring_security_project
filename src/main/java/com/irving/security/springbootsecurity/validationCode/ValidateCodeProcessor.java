package com.irving.security.springbootsecurity.validationCode;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeProcessor {
    StringBuffer SESSION_KEY_PREFIX = new StringBuffer("SESSION_KEY_FOR_CODE_");

    void create(ServletWebRequest request) throws Exception;
}
