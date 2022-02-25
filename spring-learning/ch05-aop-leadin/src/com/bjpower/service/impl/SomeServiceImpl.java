package com.bjpower.service.impl;

import com.bjpower.service.SomeService;
import com.bjpower.util.ServiceTools;

import java.util.Date;

// service类的代码不修改，也能增加输出时间和事务提交
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
//        ServiceTools.doLog();
        System.out.println("doSome");
//        ServiceTools.doTransaction();
    }

    @Override
    public void doOther() {
        System.out.println(new Date());
        System.out.println("doOther");
        System.out.println("submit");
    }
}
