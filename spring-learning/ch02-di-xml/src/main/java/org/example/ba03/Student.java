package org.example.ba03;

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

    /*
    *   有参数构造
    * */

    public Student(String myName, int myAge, School mySchool) {
        System.out.println("有参数构造方法");
        this.name = myName;
        this.age = myAge;
        this.school = mySchool;
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
