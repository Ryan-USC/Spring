package org.example;

import static org.junit.Assert.assertTrue;

import org.example.service.SomeService;
import org.example.service.impl.SomeServiceImpl;
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
        SomeService service = new SomeServiceImpl();
        service.doSome();
    }

    @Test
    public void test02(){
        // 使用spring容器创建对象
        //1、指定spring配置文件的名称
        String config = "beans.xml";
        //2、创建表示spring容器的对象，ApplicationContext
        // ApplicationContext就是表示spring容器，通过容器获取对象
        // ClassPathXmlApplicationContext：表示从类路径中加载spring的配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        // 从容器中过去某个对象，调用对象的方法
        SomeService service = (SomeService) ac.getBean("someService");
        service.doSome();
    }
}
