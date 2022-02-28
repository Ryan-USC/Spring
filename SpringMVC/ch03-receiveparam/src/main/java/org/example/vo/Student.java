package org.example.vo;

//保存请求参数值的普通类
public class Student {

    // 属性名和请求中参数名一样
    private String name;
    private Integer age;

    public Student() {
        System.out.println("Student无参数构造");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Name:" + name);
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("Age:" + age);
        this.age = age;
    }
}
