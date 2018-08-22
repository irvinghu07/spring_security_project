package com.irving.security.springbootsecurity.security_browser;

import com.irving.security.springbootsecurity.security_browser.support.SocialUserInfo;
import com.irving.security.springbootsecurity.security_core.properties.SecurityConstants;
import com.irving.security.springbootsecurity.security_core.properties.SecurityProperties;
import com.irving.security.springbootsecurity.security_browser.support.SimpleResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class BrowserSecurityController {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ProviderSignInUtils signInUtils;

    private RequestCache requestCache = new HttpSessionRequestCache();

    private static final Logger logger = LoggerFactory.getLogger(BrowserSecurityController.class);

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @RequestMapping(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String target = savedRequest.getRedirectUrl();
            logger.info("引发跳转的请求是：{}", target);
            if (StringUtils.endsWithIgnoreCase(target, ".html")) {
                logger.info("redirecting to login page:{}", securityProperties.getBrowserProperties().getLoginPage());
                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowserProperties().getLoginPage());
            }
        }
        return new SimpleResponse("访问的服务需要身份验证，请引导用户到登录页面");
    }

    @GetMapping("/social/user")
    public SocialUserInfo getSocialInfo(HttpServletRequest request) {
        SocialUserInfo userInfo = new SocialUserInfo();
        Connection<?> connection = signInUtils.getConnectionFromSession(new ServletWebRequest(request));
        userInfo.setProviderId(connection.getKey().getProviderId());
        userInfo.setProviderUserId(connection.getKey().getProviderUserId());
        userInfo.setUsername(connection.getDisplayName());
        userInfo.setAvatar(connection.getImageUrl());
        return userInfo;
    }

}
