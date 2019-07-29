package com.cym.struts2.demo1.service.impl;

import com.cym.struts2.demo1.service.HelloWorld;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * Created by Administrator on 2019/7/19.
 */
@Component("helloWorld")
@WebService
public class HelloWorldImpl implements HelloWorld{
    @Override
    public String say(String str) {
        System.out.println(str);
        return "这是我返回的消息，"+str;
    }
}
