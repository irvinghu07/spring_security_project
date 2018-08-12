package com.irving.security.springbootsecurity.security_core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

public class ImoocSpringSocialConfigurer extends SpringSocialConfigurer {
    private String processesUrl;

    public ImoocSpringSocialConfigurer(String processesUrl) {
        this.processesUrl = processesUrl;
    }

    /**
     * Performs post processing of an object. The default is to delegate to the
     *
     * @param object the Object to post process
     * @return the possibly modified Object to use
     */
    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter)super.postProcess(object);
        filter.setFilterProcessesUrl(processesUrl);
        return (T) filter;
    }
}
