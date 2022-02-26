package org.example.ba06;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component("myStudent")
public class Student {
    @Value("ryan")
    private String name;
    @Value("29")
    private Integer age;

    /*
    *   引用类型
    *   @Resource：来自JDK中的注解，spring框架提供了对这个注解的功能支持，可以使用它给引用类型赋值
    *   使用的也是自动注入原理，支持byName，byType，默认是byName
    *   位置：1、在属性定义的上面，无需set方法，推荐使用。
    *        2、在set方法上面
    *
    *
    * */
    //默认是byName：先使用byName自动注入，如果byName失败，再使用byType

    private School school;


    public Student() {
        System.out.println("无参数构造方法");
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
