package com.irving.security.springbootsecurity.validationCode;

import com.irving.security.springbootsecurity.validationCode.image.ImageCode;
import com.irving.security.springbootsecurity.validationCode.message.MessageCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ValidateCodeController {

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;

    @Autowired
    private ValidateCodeGenerator messageCodeGenerator;

    @Autowired
    private MessageCodeSender messageCodeSender;

    public static final String SESSION_KEY_CAPTCHA = "SESSION_KEY_IMAGE_CODE";
    public static final String SESSION_KEY_MESSAGE = "SESSION_KEY_message_CODE";
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @GetMapping("/code/image")
    public void createImageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode = (ImageCode) imageCodeGenerator.generateCode(new ServletWebRequest(request));
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY_CAPTCHA, imageCode);
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
    }

    @GetMapping("/code/message")
    public void createMessageCode(HttpServletRequest request) throws ServletRequestBindingException {
        ValidateCode validateCode = imageCodeGenerator.generateCode(new ServletWebRequest(request));
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY_MESSAGE, validateCode);
        messageCodeSender.send(ServletRequestUtils.getStringParameter(request, ServletRequestUtils
                .getStringParameter(request, "mobile")), validateCode.getCode());
    }
}
