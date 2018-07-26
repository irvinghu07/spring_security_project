package com.irving.security.springbootsecurity.service;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class MyUserDetailsService implements UserDetailsService {
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
        logger.info("登录用户信息: {}", username);
//        !!!!!
//        "{noop}123456"
//        方法一：在实体类中实现UserDetails接口并重写四个布尔类型的方法确认是否valid
//        方法二：返回新的org.springframework.security.core.userdetails.User对象时使用七个参数的方法来判断是否valid

//        String finalPwd = passwordEncoder.encode("123456");
        String encoding = "SHA-256";
        String rowPass = "123456";
        String processedPass = getSHA256Str(rowPass);
//        logger.info("password from md5: {}", processedPass);
        String finalPwd = passwordEncoder.encode(rowPass);
        finalPwd = "{" + encoding + "}" + processedPass;
        logger.info("encoding{} password:{}", encoding, finalPwd);
        logger.info("match: {}", passwordEncoder.matches("123456", finalPwd));
        return new User(username, finalPwd, true, true, true, true, AuthorityUtils
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
