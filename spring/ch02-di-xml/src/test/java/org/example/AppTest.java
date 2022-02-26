package org.example;

import static org.junit.Assert.assertTrue;

import org.example.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void test01(){
        String config = "ba01/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        // 先创建构造方法，在执行set方法执行赋值
        Student myStudent = (Student) ac.getBean("myStudent");
        System.out.println(myStudent);

        Date myDate = (Date) ac.getBean("mydate");
        System.out.println(myDate);

    }





}
