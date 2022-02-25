package com.bjpower.handler;

import com.bjpower.util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationhandler implements InvocationHandler {
    // 目标对象
    private Object target; // SomeServiceImpl类

    public MyInvocationhandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过代理对象执行方法时，会调用这个invoke（）
        System.out.println("执行了invoke方法");
        Object res = null;
        ServiceTools.doLog();
        //执行目标类的方法，通过Method类实现
        res = method.invoke(target, args); // SomeServiceImpl.doOther(), doSome()
        ServiceTools.doTransaction();
        //目标方法执行结果
        return res;
    }
}
