package org.example;

import org.example.ba05.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AppTest5
{
    @Test
    public void test04(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        // 从容器中获取目标对象
        SomeServiceImpl proxy = (SomeServiceImpl) ctx.getBean("someService");
        /*
        * 目标类没有接口使用的是cglib动态代理
        * */
        proxy.doThird();
        System.out.println(proxy.getClass().getName());


    }
}
