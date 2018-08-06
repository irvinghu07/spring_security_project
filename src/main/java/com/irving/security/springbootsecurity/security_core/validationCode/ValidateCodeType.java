package com.irving.security.springbootsecurity.security_core.validationCode;

import com.irving.security.springbootsecurity.security_core.properties.SecurityConstants;

public enum ValidateCodeType {

    /**
     * 短信验证码
     */
    MESSAGE {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_MESSAGE;
        }
    },
    /**
     * 图片验证码
     */
    IMAGE {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };

    /**
     * 校验时从请求中获取的参数的名字
     *
     * @return
     */
    public abstract String getParamNameOnValidate();

}
