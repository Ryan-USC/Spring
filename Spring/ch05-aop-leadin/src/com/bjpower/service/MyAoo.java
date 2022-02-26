package com.bjpower.service;

import com.bjpower.handler.MyInvocationhandler;
import com.bjpower.service.impl.SomeServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyAoo {
    public static void main(String[] args) {
//        SomeService service = new SomeServiceImpl();
//        service.doSome();
//        System.out.println("-=-=-=-=-=-=================");
//        service.doOther();

        //使用JDK的proxy创代理对象
        SomeService target = new SomeServiceImpl();

        //创建InvocaitonHandler对象
        InvocationHandler handler = new MyInvocationhandler(target);

        //创建proxy创建代理
        SomeService proxy = (SomeService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);

        //通过代理执行方法，会调用handler中的invoke()
        proxy.doSome();
    }
}
