package com.bjpower.util;

import java.util.Date;

public class ServiceTools {

    public static void doLog(){
        System.out.println("非业务"+new Date());
    }
    public static void doTransaction(){
        System.out.println("非业务:"+"提交事务");
    }
}
