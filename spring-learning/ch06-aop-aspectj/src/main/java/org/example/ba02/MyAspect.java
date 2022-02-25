package org.example.ba02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

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
    * 后置通知定义方法，方法是实现切面功能的
    * 方法定义要求：
    * 1、公共方法 public
    * 2、方法没有返回值
    * 3、方法名称自定义
    * 4、方法有参数，推荐是Object，参数名自定义
    *
    * */



    /*
    * @AfterReturning: 后置通知
    *   属性：1、value：切入点表达式
    *        2、returning 自定义的变量，表示目标方法的返回值的。
    *           自定义变量必须和通知方法的形参名一样
    *   位置：在方法定义的上面
    *
    * 特点：
    * 1、在目标方法之后执行的
    * 2、能够获取目标方法的返回值，可以根据这个返回值做不同的处理功能
    * 3、可以修改这个返回值
    *
    * 后置通知的执行
    *   Obejct res = doOther();
    *   myAfterReturning(res);
    * */

    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))", returning = "res")
    public void myAfterReturning(JoinPoint joinPoint, Object res){
        // Object res：是目标方法执行之后的返回值，根据返回值做你的切面处理功能
        System.out.println("获取的返回值是" + res);
        System.out.println("方法的签名（定义）：" + joinPoint.getSignature());
        System.out.println("方法的名称=" + joinPoint.getSignature().getName());
        // 修改目标方法的返回值，是否会影响最后的方法调用结果
        if (res != null){
            res = "hello";
        }
    }
}
