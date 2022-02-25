package org.example;

import static org.junit.Assert.assertTrue;

import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class AppTest 
{
    @Test
    public void test01()
    {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        String names[] = ctx.getBeanDefinitionNames();
        for (String name: names){
            System.out.println(name);
        }
    }

    @Test
    public void testDaoInsert()
    {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        StudentService service = (StudentService) ctx.getBean("studentService");
        Student student = new Student();
        student.setId(1015);
        student.setName("jayyy");
        student.setAge(26);
        student.setEmail("jayyy@163.com");
        int num = service.addStudent(student);
        // spring和mybatis整合在一起使用，事务是自动提交的，无需执行Sqlsession.commit()
        System.out.println(num);
    }

    @Test
    public void testServiceSelect()
    {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        StudentService service = (StudentService) ctx.getBean("studentService");
        List<Student> list = service.queryStudents();
        list.forEach(student -> System.out.println(student));
    }
}
