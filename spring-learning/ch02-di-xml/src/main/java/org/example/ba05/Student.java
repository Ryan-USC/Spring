package org.example.ba05;

public class Student {
    private String name;
    private int age;
    private School school;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }

    public Student() {
        System.out.println("无参数构造方法");
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*
    *   有参数构造
    * */

    public Student(String name, int age, School school) {
        System.out.println("有参数构造方法");
        this.name = name;
        this.age = age;
        this.school = school;
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

    public void setSchool(School school) { this.school = school; }
}
