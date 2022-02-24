package org.example.ba02;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
* @Value：简单类型的属性赋值
*   属性：value是String类型的，表示简单类型的属性值
*   位置：1、在属性定义上面，无需set方法，推荐使用
*        2、在set方法上面
*
* */


@Component("myStudent")
public class Student {
    @Value("ryan")
    private String name;
    @Value("29")
    private Integer age;


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
                '}';
    }
}
