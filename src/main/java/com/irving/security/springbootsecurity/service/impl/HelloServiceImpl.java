package com.irving.security.springbootsecurity.service.impl;

import com.irving.security.springbootsecurity.service.HelloService;
import org.springframework.stereotype.Service;

@Service(value = "helloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String greeting(String name) {
        System.out.println("greeting()");
        return String.format("hello %s",name);
    }
}
