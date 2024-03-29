package org.example.ba01;

public class Student {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student() {
        System.out.println("无参数构造方法");
    }
    /*
    *   需要有set方法，不然会报错
    *
    * */

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void  setEmail(String email){
        System.out.println(email);
    }
}
