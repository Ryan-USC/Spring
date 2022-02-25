package org.example;

import static org.junit.Assert.assertTrue;

import org.example.ba01.SomeService;
import org.example.ba01.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        // 从容器中获取目标对象
        SomeService proxy = (SomeService) ctx.getBean("someService");
        // 通过代理的对象执行方法，实现目标方法执行时，增强了功能
        proxy.doSome("lisi", 20);
    }
}
