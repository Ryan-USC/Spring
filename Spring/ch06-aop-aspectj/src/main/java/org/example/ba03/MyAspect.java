package org.example.ba03;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;

/*
* @Aspect：是aspectj框架中的注解
* 作用：表示当前类是切面类
* 切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能代码
* 位置：在类定义的上面
* */
@Aspect
public class MyAspect {
    /*
    * 环绕通知方法的定义格式：
    *   1、public
    *   2、必须有一个返回值，推荐使用Obejct
    *   3、方法名称自定义
    *   4、方法有参数，固定的参数ProceedingJoinPoint
    * */

    /*
    * @Around：环绕通知
    *   属性：value切入点表达式
    *   位置：在方法定义上面
    * 特点：
    *   1、他是功能最强的通知
    *   2、在目标方法前后都能增强功能
    *   3、控制目标方法是否能被调用执行
    *   4、修改原来的目标方法的执行结果，影响最后的调用结果
    *
    *   环绕通知，等同于jdk动态代理，InvocationHandler接口
    *
    *   参数：ProceedingJoinPoint 就等同于Method
    *       作用：执行目标方法的
    *   返回值：就是目标方法的执行结果，可以被修改
    *
    * 环绕通知：经常做事务，在目标方法之前开启事务，执行目标方法，在目标方法之后提交事务
    *
    * */
    @Around(value = "execution(* *..SomeServiceImpl.doFirst(..))")

    public Object myAfterReturning(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String name = "";
        //获取第一个参数值
        Object args [] = proceedingJoinPoint.getArgs();
        if (args != null && args.length > 1){
            Object arg = args[0];
            name = (String)arg;
        }



        // 实现环绕通知
        Object res = null;
        System.out.println("环绕通知：在目标方法之前，输出时间+" + new Date());
        //1.实现方法调用
        if (name.equals("ryan")) {
            res = proceedingJoinPoint.proceed();
        }
        System.out.println("环绕通知：在目标方法后提交事务" );
        //2.在目标方法的前后加入功能

        // 修改目标方法的执行结果
        if (res != null){
            res = "hello aop";
        }
        return res;
    }
}
