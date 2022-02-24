package org.example;

import org.example.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest03
{


    @Test
    public void test03(){
        String config = "ba03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        Student myStudent = (Student) ac.getBean("myStudent");
        System.out.println(myStudent);

        Student myStudent2 = (Student) ac.getBean("mystudent2");
        System.out.println(myStudent2);
    }






}
