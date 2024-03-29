package org.example.ba05;


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
    *   @Autowired：spring框架提供的注解，实现引用类型的赋值
    *   spring中通过注解给引用类型赋值，使用的是自动注入的原理，支持byName，byType
    *   @Autowired：默认使用的是byType自动注入。
    *
    * 属性：requied，是一个布尔类型的，默认true
    *   required=true：表示引用类型赋值失败，程序报错，并终止执行。
    *   required=false：引用类型如果赋值失败，程序正常执行，引用类型是null
    *
    * 位置：1）在属性定义的上面，无需set方法，推荐使用
    *      2）在set方法上面
    *
    * 如果要使用byName方式，需要做的是：
    * 1、在属性上面加入@Autowired
    * 2、在属性上面加入@Qualifier(value="bean的id")：表示使用指定名称的bean完成赋值
    * */
    @Autowired
    @Qualifier("mySchool-1")
    private School school;


    public Student() {
        System.out.println("无参数构造方法");
    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
