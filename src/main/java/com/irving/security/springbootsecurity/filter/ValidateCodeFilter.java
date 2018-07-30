package com.irving.security.springbootsecurity.filter;

import com.irving.security.springbootsecurity.CAPTCHA.ImageCode;
import com.irving.security.springbootsecurity.authentication.LoginAuthenticationFailureHandler;
import com.irving.security.springbootsecurity.controller.ValidateCodeController;
import com.irving.security.springbootsecurity.exception.ValidateCodeException;
import com.irving.security.springbootsecurity.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component("validateCodeFilter")
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private LoginAuthenticationFailureHandler loginAuthenticationFailureHandler;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    private Set<String> allUrls = new HashSet<String>() {{
        add("/authentication/form");
    }};

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    /**
     * Calls the {@code initFilterBean()} method that might
     * contain custom initialization of a subclass.
     * <p>Only relevant in case of initialization as bean, where the
     * standard {@code init(FilterConfig)} method won't be called.
     *
     * @see #initFilterBean()
     * @see #init(FilterConfig)
     */
    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        String[] urlSet = StringUtils.splitByWholeSeparatorPreserveAllTokens(
                securityProperties.getValidateCodeProperties().getImageCodeProperties().getUrls(), ",");
//        allUrls.add();
        for (String url : urlSet) {
            allUrls.add(url);
        }
    }

    /**
     * Same contract as for {@code doFilter}, but guaranteed to be
     * just invoked once per request within a single request thread.
     * See {@link #shouldNotFilterAsyncDispatch()} for details.
     * <p>Provides HttpServletRequest and HttpServletResponse arguments instead of the
     * default ServletRequest and ServletResponse ones.
     *
     * @param request
     * @param response
     * @param filterChain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        boolean needValidation = false;
        for (String url : allUrls) {
            if (pathMatcher.match(url, request.getRequestURI())) {
                needValidation = true;
            }
        }
        if (needValidation) {
            try {
                validate(new ServletWebRequest(request));
            } catch (ValidateCodeException e) {
                loginAuthenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    private void validate(ServletWebRequest request) throws ServletRequestBindingException {
        ImageCode codeInSession = (ImageCode) sessionStrategy.getAttribute(request,
                ValidateCodeController.SESSION_KEY);
        String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");
        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("验证码的值不能为空");
        }

        if (codeInSession == null) {
            throw new ValidateCodeException("验证码不存在");
        }

        if (codeInSession.isExpried()) {
            sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
            throw new ValidateCodeException("验证码已过期");
        }

        if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
            throw new ValidateCodeException("验证码不匹配");
        }

        sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
    }

}