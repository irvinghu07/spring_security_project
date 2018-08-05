.
├── Springboot-Security-Project
│   ├── LICENSE
│   └── README.md
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
│   │   │                   ├── authentication
│   │   │                   │   ├── AbstractChannelSecurityConfig.java
│   │   │                   │   ├── LoginAuthenticationFailureHandler.java
│   │   │                   │   ├── LoginAuthenticationSuccessHandler.java
│   │   │                   │   └── mobile
│   │   │                   │       ├── MessageCodeAuthenticationFilter.java
│   │   │                   │       ├── MessageCodeAuthenticationProvider.java
│   │   │                   │       ├── MessageCodeAuthenticationSecurityConfig.java
│   │   │                   │       └── MessageCodeAuthenticationToken.java
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
│   │   │                   │   └── User.java
│   │   │                   ├── exception
│   │   │                   │   └── UserNotExistException.java
│   │   │                   ├── filter
│   │   │                   │   └── TimeFilter.java
│   │   │                   ├── handler
│   │   │                   │   └── ControllerExceptionHandler.java
│   │   │                   ├── interceptor
│   │   │                   │   └── TimeInterceptor.java
│   │   │                   ├── properties
│   │   │                   │   ├── BrowserProperties.java
│   │   │                   │   ├── ImageCodeProperties.java
│   │   │                   │   ├── LoginType.java
│   │   │                   │   ├── MessageCodeProperties.java
│   │   │                   │   ├── SecurityConstants.java
│   │   │                   │   ├── SecurityProperties.java
│   │   │                   │   └── ValidateCodeProperties.java
│   │   │                   ├── service
│   │   │                   │   ├── HelloService.java
│   │   │                   │   ├── MyUserDetailsService.java
│   │   │                   │   └── impl
│   │   │                   │       └── HelloServiceImpl.java
│   │   │                   ├── support
│   │   │                   │   └── SimpleResponse.java
│   │   │                   ├── validationCode
│   │   │                   │   ├── ValidateCode.java
│   │   │                   │   ├── ValidateCodeBeanConfig.java
│   │   │                   │   ├── ValidateCodeController.java
│   │   │                   │   ├── ValidateCodeException.java
│   │   │                   │   ├── ValidateCodeFilter.java
│   │   │                   │   ├── ValidateCodeGenerator.java
│   │   │                   │   ├── ValidateCodeProcessor.java
│   │   │                   │   ├── ValidateCodeProcessorHolder.java
│   │   │                   │   ├── ValidateCodeSecurityConfig.java
│   │   │                   │   ├── ValidateCodeType.java
│   │   │                   │   ├── image
│   │   │                   │   │   ├── ImageCode.java
│   │   │                   │   │   ├── ImageCodeGenerator.java
│   │   │                   │   │   └── ImageCodeProcessor.java
│   │   │                   │   ├── impl
│   │   │                   │   │   └── AbstractValidateCodeProcessor.java
│   │   │                   │   └── message
│   │   │                   │       ├── DefaultMessageCodeSender.java
│   │   │                   │       ├── MessageCodeGenerator.java
│   │   │                   │       ├── MessageCodeProcessor.java
│   │   │                   │       └── MessageCodeSender.java
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
│   │       │   ├── error
│   │       │   │   └── 404.html
│   │       │   ├── index.html
│   │       │   └── security-login.html
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
│   │   │               ├── authentication
│   │   │               │   ├── AbstractChannelSecurityConfig.class
│   │   │               │   ├── LoginAuthenticationFailureHandler.class
│   │   │               │   ├── LoginAuthenticationSuccessHandler.class
│   │   │               │   └── mobile
│   │   │               │       ├── MessageCodeAuthenticationFilter.class
│   │   │               │       ├── MessageCodeAuthenticationProvider.class
│   │   │               │       ├── MessageCodeAuthenticationSecurityConfig.class
│   │   │               │       └── MessageCodeAuthenticationToken.class
│   │   │               ├── config
│   │   │               │   ├── BrowserSecurityConfig.class
│   │   │               │   └── WebConfig.class
│   │   │               ├── controller
│   │   │               │   ├── BrowserSecurityController.class
│   │   │               │   ├── FileController.class
│   │   │               │   ├── UserController$1.class
│   │   │               │   └── UserController.class
│   │   │               ├── domain
│   │   │               │   ├── FileInfo.class
│   │   │               │   ├── QueryCondition.class
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
│   │   │               ├── properties
│   │   │               │   ├── BrowserProperties.class
│   │   │               │   ├── ImageCodeProperties.class
│   │   │               │   ├── LoginType.class
│   │   │               │   ├── MessageCodeProperties.class
│   │   │               │   ├── SecurityConstants.class
│   │   │               │   ├── SecurityProperties.class
│   │   │               │   └── ValidateCodeProperties.class
│   │   │               ├── service
│   │   │               │   ├── HelloService.class
│   │   │               │   ├── MyUserDetailsService.class
│   │   │               │   └── impl
│   │   │               │       └── HelloServiceImpl.class
│   │   │               ├── support
│   │   │               │   └── SimpleResponse.class
│   │   │               ├── validationCode
│   │   │               │   ├── ValidateCode.class
│   │   │               │   ├── ValidateCodeBeanConfig.class
│   │   │               │   ├── ValidateCodeController.class
│   │   │               │   ├── ValidateCodeException.class
│   │   │               │   ├── ValidateCodeFilter.class
│   │   │               │   ├── ValidateCodeGenerator.class
│   │   │               │   ├── ValidateCodeProcessor.class
│   │   │               │   ├── ValidateCodeProcessorHolder.class
│   │   │               │   ├── ValidateCodeSecurityConfig.class
│   │   │               │   ├── ValidateCodeType$1.class
│   │   │               │   ├── ValidateCodeType$2.class
│   │   │               │   ├── ValidateCodeType.class
│   │   │               │   ├── image
│   │   │               │   │   ├── ImageCode.class
│   │   │               │   │   ├── ImageCodeGenerator.class
│   │   │               │   │   └── ImageCodeProcessor.class
│   │   │               │   ├── impl
│   │   │               │   │   └── AbstractValidateCodeProcessor.class
│   │   │               │   └── message
│   │   │               │       ├── DefaultMessageCodeSender.class
│   │   │               │       ├── MessageCodeGenerator.class
│   │   │               │       ├── MessageCodeProcessor.class
│   │   │               │       └── MessageCodeSender.class
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
│   │   │   ├── error
│   │   │   │   └── 404.html
│   │   │   ├── index.html
│   │   │   └── security-login.html
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

87 directories, 150 files
