package org.example.ba02;

//目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        //给doSome增加功能，在doSome执行之前，输出方法的执行时间
        System.out.println("=====execute doSome()======");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("=====execute doOther()======");
        return "abcd";
    }
}
