package com.irving.security.springbootsecurity.security;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService, SocialUserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        根据用户名使用数据持久层查找用户信息
        logger.info("表单登录用户名: {}", username);
        return buildUser(username);
    }

    /**
     * @param userId the user ID used to lookup the user details
     * @return the SocialUserDetails requested
     * @see UserDetailsService#loadUserByUsername(String)
     */
    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
//        根据用户名使用数据持久层查找用户信息
        logger.info("社交登录用户ID: {}", userId);
        return buildUser(userId);
    }

    private SocialUserDetails buildUser(String userId) {
        //        !!!!!
//        "{noop}123456"
//        方法一：在实体类中实现UserDetails接口并重写四个布尔类型的方法确认是否valid
//        方法二：返回新的org.springframework.security.core.userdetails.User对象时使用七个参数的方法来判断是否valid


//        String encoding = "SHA-256";
//        String finalPwd = "{" + encoding + "}" + processedPass;
        String rowPass = "123456";
        String finalPwd = passwordEncoder.encode(rowPass);

        logger.info("数据库密码是:{}", finalPwd);
        return new SocialUser(userId, finalPwd, true, true, true, true, AuthorityUtils
                .commaSeparatedStringToAuthorityList("admin"));
    }


    public static String getSHA256Str(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encodeStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }
}
