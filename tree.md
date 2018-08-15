.
├── README.md
├── mvnw
├── mvnw.cmd
├── pom.xml
├── springboot-security.iml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── irving
│   │   │           └── security
│   │   │               └── springbootsecurity
│   │   │                   ├── CAPTCHA
│   │   │                   │   └── DemoImageCodeGenerator.java
│   │   │                   ├── SpringbootSecurityApplication.java
│   │   │                   ├── aspect
│   │   │                   │   └── TimeAspect.java
│   │   │                   ├── async
│   │   │                   │   ├── AsyncController.java
│   │   │                   │   ├── DeferredResultHolder.java
│   │   │                   │   ├── MockQueue.java
│   │   │                   │   └── QueueListener.java
│   │   │                   ├── config
│   │   │                   │   ├── BrowserSecurityConfig.java
│   │   │                   │   └── WebConfig.java
│   │   │                   ├── controller
│   │   │                   │   ├── BrowserSecurityController.java
│   │   │                   │   ├── FileController.java
│   │   │                   │   └── UserController.java
│   │   │                   ├── domain
│   │   │                   │   ├── FileInfo.java
│   │   │                   │   ├── QueryCondition.java
│   │   │                   │   ├── SocialUserInfo.java
│   │   │                   │   └── User.java
│   │   │                   ├── exception
│   │   │                   │   └── UserNotExistException.java
│   │   │                   ├── filter
│   │   │                   │   └── TimeFilter.java
│   │   │                   ├── handler
│   │   │                   │   └── ControllerExceptionHandler.java
│   │   │                   ├── interceptor
│   │   │                   │   └── TimeInterceptor.java
│   │   │                   ├── security
│   │   │                   │   ├── DemoConnectionSignUp.java
│   │   │                   │   └── MyUserDetailsService.java
│   │   │                   ├── security_core
│   │   │                   │   ├── authentication
│   │   │                   │   │   ├── AbstractChannelSecurityConfig.java
│   │   │                   │   │   ├── LoginAuthenticationFailureHandler.java
│   │   │                   │   │   ├── LoginAuthenticationSuccessHandler.java
│   │   │                   │   │   └── mobile
│   │   │                   │   │       ├── MessageCodeAuthenticationFilter.java
│   │   │                   │   │       ├── MessageCodeAuthenticationProvider.java
│   │   │                   │   │       ├── MessageCodeAuthenticationSecurityConfig.java
│   │   │                   │   │       └── MessageCodeAuthenticationToken.java
│   │   │                   │   ├── properties
│   │   │                   │   │   ├── BrowserProperties.java
│   │   │                   │   │   ├── ImageCodeProperties.java
│   │   │                   │   │   ├── LoginType.java
│   │   │                   │   │   ├── MessageCodeProperties.java
│   │   │                   │   │   ├── QQProperties.java
│   │   │                   │   │   ├── SecurityConstants.java
│   │   │                   │   │   ├── SecurityProperties.java
│   │   │                   │   │   ├── SocialProperties.java
│   │   │                   │   │   ├── ValidateCodeProperties.java
│   │   │                   │   │   └── WeixinProperties.java
│   │   │                   │   ├── social
│   │   │                   │   │   ├── ImoocSpringSocialConfigurer.java
│   │   │                   │   │   ├── SocialConfig.java
│   │   │                   │   │   ├── qq
│   │   │                   │   │   │   ├── api
│   │   │                   │   │   │   │   ├── QQ.java
│   │   │                   │   │   │   │   ├── QQImpl.java
│   │   │                   │   │   │   │   └── QQUserInfo.java
│   │   │                   │   │   │   ├── config
│   │   │                   │   │   │   │   └── QQAutoConfig.java
│   │   │                   │   │   │   └── connect
│   │   │                   │   │   │       ├── QQAdapter.java
│   │   │                   │   │   │       ├── QQConnectionFactory.java
│   │   │                   │   │   │       ├── QQOAuth2Template.java
│   │   │                   │   │   │       └── QQServiceProvider.java
│   │   │                   │   │   └── weixin
│   │   │                   │   │       ├── api
│   │   │                   │   │       │   ├── Weixin.java
│   │   │                   │   │       │   ├── WeixinImpl.java
│   │   │                   │   │       │   └── WeixinUserInfo.java
│   │   │                   │   │       ├── config
│   │   │                   │   │       │   └── WeixinAutoConfiguration.java
│   │   │                   │   │       └── connect
│   │   │                   │   │           ├── WeixinAccessGrant.java
│   │   │                   │   │           ├── WeixinAdapter.java
│   │   │                   │   │           ├── WeixinConnectionFactory.java
│   │   │                   │   │           ├── WeixinOAuth2Template.java
│   │   │                   │   │           └── WeixinServiceProvider.java
│   │   │                   │   └── validationCode
│   │   │                   │       ├── ValidateCode.java
│   │   │                   │       ├── ValidateCodeBeanConfig.java
│   │   │                   │       ├── ValidateCodeController.java
│   │   │                   │       ├── ValidateCodeException.java
│   │   │                   │       ├── ValidateCodeFilter.java
│   │   │                   │       ├── ValidateCodeGenerator.java
│   │   │                   │       ├── ValidateCodeProcessor.java
│   │   │                   │       ├── ValidateCodeProcessorHolder.java
│   │   │                   │       ├── ValidateCodeSecurityConfig.java
│   │   │                   │       ├── ValidateCodeType.java
│   │   │                   │       ├── image
│   │   │                   │       │   ├── ImageCode.java
│   │   │                   │       │   ├── ImageCodeGenerator.java
│   │   │                   │       │   └── ImageCodeProcessor.java
│   │   │                   │       ├── impl
│   │   │                   │       │   └── AbstractValidateCodeProcessor.java
│   │   │                   │       └── message
│   │   │                   │           ├── DefaultMessageCodeSender.java
│   │   │                   │           ├── MessageCodeGenerator.java
│   │   │                   │           ├── MessageCodeProcessor.java
│   │   │                   │           └── MessageCodeSender.java
│   │   │                   ├── service
│   │   │                   │   ├── HelloService.java
│   │   │                   │   └── impl
│   │   │                   │       └── HelloServiceImpl.java
│   │   │                   ├── support
│   │   │                   │   └── SimpleResponse.java
│   │   │                   ├── validator
│   │   │                   │   ├── MyConstraint.java
│   │   │                   │   └── MyConstraintValidator.java
│   │   │                   └── wiremock
│   │   │                       └── MockServer.java
│   │   └── resources
│   │       ├── application.yml
│   │       ├── response
│   │       │   ├── 01.txt
│   │       │   └── 02.txt
│   │       ├── static
│   │       │   ├── demo-login.html
│   │       │   ├── demo-signup.html
│   │       │   ├── error
│   │       │   │   └── 404.html
│   │       │   ├── index.html
│   │       │   ├── security-login.html
│   │       │   └── security-signup.html
│   │       ├── templates
│   │       └── upload
│   │           └── 1532436230370.txt
│   └── test
│       └── java
│           └── com
│               └── irving
│                   └── security
│                       └── springbootsecurity
│                           └── SpringbootSecurityApplicationTests.java
├── target
│   ├── classes
│   │   ├── application.yml
│   │   ├── com
│   │   │   └── irving
│   │   │       └── security
│   │   │           └── springbootsecurity
│   │   │               ├── CAPTCHA
│   │   │               │   └── DemoImageCodeGenerator.class
│   │   │               ├── SpringbootSecurityApplication.class
│   │   │               ├── aspect
│   │   │               │   └── TimeAspect.class
│   │   │               ├── async
│   │   │               │   ├── AsyncController$1.class
│   │   │               │   ├── AsyncController.class
│   │   │               │   ├── DeferredResultHolder.class
│   │   │               │   ├── MockQueue.class
│   │   │               │   └── QueueListener.class
│   │   │               ├── config
│   │   │               │   └── BrowserSecurityConfig.class
│   │   │               ├── controller
│   │   │               │   ├── BrowserSecurityController.class
│   │   │               │   ├── FileController.class
│   │   │               │   ├── UserController$1.class
│   │   │               │   └── UserController.class
│   │   │               ├── domain
│   │   │               │   ├── FileInfo.class
│   │   │               │   ├── QueryCondition.class
│   │   │               │   ├── SocialUserInfo.class
│   │   │               │   ├── User$UserDetailView.class
│   │   │               │   ├── User$UserSimpleView.class
│   │   │               │   └── User.class
│   │   │               ├── exception
│   │   │               │   └── UserNotExistException.class
│   │   │               ├── filter
│   │   │               │   └── TimeFilter.class
│   │   │               ├── handler
│   │   │               │   ├── ControllerExceptionHandler$1.class
│   │   │               │   └── ControllerExceptionHandler.class
│   │   │               ├── interceptor
│   │   │               │   └── TimeInterceptor.class
│   │   │               ├── security
│   │   │               │   ├── DemoConnectionSignUp.class
│   │   │               │   └── MyUserDetailsService.class
│   │   │               ├── security_core
│   │   │               │   ├── authentication
│   │   │               │   │   ├── AbstractChannelSecurityConfig.class
│   │   │               │   │   ├── LoginAuthenticationFailureHandler.class
│   │   │               │   │   ├── LoginAuthenticationSuccessHandler.class
│   │   │               │   │   └── mobile
│   │   │               │   │       ├── MessageCodeAuthenticationFilter.class
│   │   │               │   │       ├── MessageCodeAuthenticationProvider.class
│   │   │               │   │       ├── MessageCodeAuthenticationSecurityConfig.class
│   │   │               │   │       └── MessageCodeAuthenticationToken.class
│   │   │               │   ├── properties
│   │   │               │   │   ├── BrowserProperties.class
│   │   │               │   │   ├── ImageCodeProperties.class
│   │   │               │   │   ├── LoginType.class
│   │   │               │   │   ├── MessageCodeProperties.class
│   │   │               │   │   ├── QQProperties.class
│   │   │               │   │   ├── SecurityConstants.class
│   │   │               │   │   ├── SecurityProperties.class
│   │   │               │   │   ├── SocialProperties.class
│   │   │               │   │   ├── ValidateCodeProperties.class
│   │   │               │   │   └── WeixinProperties.class
│   │   │               │   ├── social
│   │   │               │   │   ├── ImoocSpringSocialConfigurer.class
│   │   │               │   │   ├── SocialConfig.class
│   │   │               │   │   ├── qq
│   │   │               │   │   │   ├── api
│   │   │               │   │   │   │   ├── QQ.class
│   │   │               │   │   │   │   ├── QQImpl.class
│   │   │               │   │   │   │   └── QQUserInfo.class
│   │   │               │   │   │   ├── config
│   │   │               │   │   │   │   └── QQAutoConfig.class
│   │   │               │   │   │   └── connect
│   │   │               │   │   │       ├── QQAdapter.class
│   │   │               │   │   │       ├── QQConnectionFactory.class
│   │   │               │   │   │       ├── QQOAuth2Template.class
│   │   │               │   │   │       └── QQServiceProvider.class
│   │   │               │   │   └── weixin
│   │   │               │   │       ├── api
│   │   │               │   │       │   ├── Weixin.class
│   │   │               │   │       │   ├── WeixinImpl.class
│   │   │               │   │       │   └── WeixinUserInfo.class
│   │   │               │   │       ├── config
│   │   │               │   │       │   └── WeixinAutoConfiguration.class
│   │   │               │   │       └── connect
│   │   │               │   │           ├── WeixinAccessGrant.class
│   │   │               │   │           ├── WeixinAdapter.class
│   │   │               │   │           ├── WeixinConnectionFactory.class
│   │   │               │   │           ├── WeixinOAuth2Template.class
│   │   │               │   │           └── WeixinServiceProvider.class
│   │   │               │   └── validationCode
│   │   │               │       ├── ValidateCode.class
│   │   │               │       ├── ValidateCodeBeanConfig.class
│   │   │               │       ├── ValidateCodeController.class
│   │   │               │       ├── ValidateCodeException.class
│   │   │               │       ├── ValidateCodeFilter.class
│   │   │               │       ├── ValidateCodeGenerator.class
│   │   │               │       ├── ValidateCodeProcessor.class
│   │   │               │       ├── ValidateCodeProcessorHolder.class
│   │   │               │       ├── ValidateCodeSecurityConfig.class
│   │   │               │       ├── ValidateCodeType$1.class
│   │   │               │       ├── ValidateCodeType$2.class
│   │   │               │       ├── ValidateCodeType.class
│   │   │               │       ├── image
│   │   │               │       │   ├── ImageCode.class
│   │   │               │       │   ├── ImageCodeGenerator.class
│   │   │               │       │   └── ImageCodeProcessor.class
│   │   │               │       ├── impl
│   │   │               │       │   └── AbstractValidateCodeProcessor.class
│   │   │               │       └── message
│   │   │               │           ├── DefaultMessageCodeSender.class
│   │   │               │           ├── MessageCodeGenerator.class
│   │   │               │           ├── MessageCodeProcessor.class
│   │   │               │           └── MessageCodeSender.class
│   │   │               ├── service
│   │   │               │   ├── HelloService.class
│   │   │               │   └── impl
│   │   │               │       └── HelloServiceImpl.class
│   │   │               ├── support
│   │   │               │   └── SimpleResponse.class
│   │   │               ├── validator
│   │   │               │   ├── MyConstraint.class
│   │   │               │   └── MyConstraintValidator.class
│   │   │               └── wiremock
│   │   │                   └── MockServer.class
│   │   ├── response
│   │   │   ├── 01.txt
│   │   │   └── 02.txt
│   │   ├── static
│   │   │   ├── demo-login.html
│   │   │   ├── demo-signup.html
│   │   │   ├── error
│   │   │   │   └── 404.html
│   │   │   ├── index.html
│   │   │   ├── security-login.html
│   │   │   └── security-signup.html
│   │   └── upload
│   │       └── 1532436230370.txt
│   ├── generated-sources
│   │   └── annotations
│   ├── generated-test-sources
│   │   └── test-annotations
│   ├── maven-status
│   │   └── maven-compiler-plugin
│   │       └── compile
│   │           └── default-compile
│   │               ├── createdFiles.lst
│   │               └── inputFiles.lst
│   └── test-classes
│       └── com
│           └── irving
│               └── security
│                   └── springbootsecurity
│                       └── SpringbootSecurityApplicationTests.class
└── tree.md

108 directories, 200 files
