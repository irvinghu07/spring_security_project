package com.irving.security.springbootsecurity.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

@Component
public class DemoConnectionSignUp implements ConnectionSignUp {
    private static final Logger logger = LoggerFactory.getLogger(DemoConnectionSignUp.class);

    /**
     * Sign up a new user of the application from the connection.
     *
     * @param connection the connection
     * @return the new user id. May be null to indicate that an implicit local user profile could not be created.
     */
    @Override
    public String execute(Connection<?> connection) {
        // 根据社交用户信息，默认创建用户，并返回用户唯一标示
        String generatedUserInfo = String.format("%s%d", connection.getDisplayName(), System.currentTimeMillis());
        logger.info("generatedUserInfo:{}", generatedUserInfo);
        return generatedUserInfo;
    }
}
