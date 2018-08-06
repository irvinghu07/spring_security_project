package com.irving.security.springbootsecurity.security_core.authentication.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class MessageCodeAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private AuthenticationSuccessHandler loginAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler loginAuthenticationFailureHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        MessageCodeAuthenticationFilter messageCodeAuthenticationFilter = new MessageCodeAuthenticationFilter();
        messageCodeAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        messageCodeAuthenticationFilter.setAuthenticationSuccessHandler(loginAuthenticationSuccessHandler);
        messageCodeAuthenticationFilter.setAuthenticationFailureHandler(loginAuthenticationFailureHandler);

        MessageCodeAuthenticationProvider messageCodeAuthenticationProvider = new MessageCodeAuthenticationProvider();
        messageCodeAuthenticationProvider.setUserDetailsService(userDetailsService);

        http.authenticationProvider(messageCodeAuthenticationProvider)
                .addFilterAfter(messageCodeAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
