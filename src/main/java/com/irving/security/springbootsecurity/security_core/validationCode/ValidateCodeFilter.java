package com.irving.security.springbootsecurity.security_core.validationCode;

import com.irving.security.springbootsecurity.security_core.properties.SecurityConstants;
import com.irving.security.springbootsecurity.security_core.properties.SecurityProperties;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Component("validateCodeFilter")
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {

//    private static final String SESSION_KEY = ValidateCodeProcessor.SESSION_KEY_PREFIX + "IMAGE";

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

//    private Set<String> allUrls = new HashSet<String>() {{
//        add("/authentication/form");
//    }};

    // added
    private Map<String, ValidateCodeType> urlMap = new HashedMap();

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
//        String[] urlSet = StringUtils
//                .splitByWholeSeparatorPreserveAllTokens(StringUtils
//                        .replace(securityProperties.getValidateCodeProperties()
//                                .getImageCodeProperties()
//                                .getUrls(), " ", ""), ",");
//        for (String url : urlSet) {
//            allUrls.add(url);
//        }
//        logger.info(String.format("all urls:%s", allUrls));

        urlMap.put(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM, ValidateCodeType.IMAGE);
        addUrlToMap(securityProperties.getValidateCodeProperties()
                .getImageCodeProperties().getUrls(), ValidateCodeType.IMAGE);

        urlMap.put(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE, ValidateCodeType.MESSAGE);
        addUrlToMap(securityProperties.getValidateCodeProperties()
                .getMessageCodeProperties().getUrls(), ValidateCodeType.MESSAGE);
    }

    private void addUrlToMap(String urlString, ValidateCodeType type) {
        if (StringUtils.isNotBlank(urlString)) {
            String[] urls = StringUtils.splitByWholeSeparatorPreserveAllTokens(urlString, ",");
            for (String url : urls) {
                urlMap.put(url, type);
            }
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
        ValidateCodeType type = getValidateCodeType(request);
        if (type != null) {
            logger.info(String.format("校验请求(%s)中的验证码,验证码类型%s", request.getRequestURI(), type));
            try {
                validateCodeProcessorHolder.findValidateCodeProcessor(type)
                        .validate(new ServletWebRequest(request, response));
                logger.info("验证码校验通过");
            } catch (ValidateCodeException exception) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, exception);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private ValidateCodeType getValidateCodeType(HttpServletRequest request) {
        ValidateCodeType result = null;
        if (!StringUtils.equalsIgnoreCase(request.getMethod(), "get")) {
            for (String url : urlMap.keySet()) {
                System.out.println(String.format("{%s:%s}", url, urlMap.get(url)));
                if (pathMatcher.match(url, request.getRequestURI())) {
                    result = urlMap.get(url);
                }
            }
        }
        return result;
    }

}
