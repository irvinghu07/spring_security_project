package com.irving.security.springbootsecurity.config;

import com.irving.security.springbootsecurity.authentication.LoginAuthenticationFailureHandler;
import com.irving.security.springbootsecurity.authentication.LoginAuthenticationSuccessHandler;
import com.irving.security.springbootsecurity.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private LoginAuthenticationSuccessHandler loginAuthenticationSuccessHandler;

    @Autowired
    private LoginAuthenticationFailureHandler loginAuthenticationFailureHandler;

    @Bean
    @ConditionalOnMissingBean(PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /**
     * Override this method to configure the {@link HttpSecurity}. Typically subclasses
     * should not invoke this method by calling super as it may override their
     * configuration. The default configuration is:
     *
     * <pre>
     * http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
     * </pre>
     *
     * @param http the {@link HttpSecurity} to modify
     * @throws Exception if an error occurs
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        弹出框显示
//        http.httpBasic()
        http.formLogin()
                .loginPage("/authentication/require")// /security-login.html
                .loginProcessingUrl("/authentication/form")
//                .successHandler(loginAuthenticationSuccessHandler)
//                .failureHandler(loginAuthenticationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require", securityProperties.getBrowserProperties().getLoginPage())
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()
        ;
    }
}
