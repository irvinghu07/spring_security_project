package com.irving.security.springbootsecurity.validationCode.image;

import com.irving.security.springbootsecurity.validationCode.impl.AbstractValidateCodeProcessor;
import org.springframework.web.context.request.ServletWebRequest;

public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {
    @Override
    protected void send(ServletWebRequest request, ImageCode validateCode) {

    }
}
