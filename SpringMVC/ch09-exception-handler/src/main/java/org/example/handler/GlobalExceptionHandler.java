package org.example.handler;


import org.example.exception.AgeException;
import org.example.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/*
* @ControllerAdvice：控制器增强（也就是说给控制器增加功能--异常处理功能
* 位置：在类的上面
* 特点：必须让框架知道这个注解所在的包名，需要在springmvc配置文件声明组件扫描器。
* 指定@ControllerAdvice所在的包名
* */
@ControllerAdvice
public class GlobalExceptionHandler {
    /*
    * 处理异常的方法和控制器方法的定义一样，可以有多个参数，可以有ModelAndView，String等对象类型的返回值
    *
    * 形参：Exception，表示Controller中抛出的异常对象。
    * 通过形参可以获取发生的异常信息。
    * */
    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception ex){
        //处理NameException的异常
        /*
        * 异常发生处理逻辑：
        * 1、把异常记录下来，记录到数据库，日志文件
        *   记录异常发生的时间，哪个方法发生的，异常错误内容
        * 2、发送通知，把异常的信息通过邮件，短信，微信发送给相关人员
        * 3、给用户友好的提示。
        * */

        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "姓名必须是张三，其他用户不能访问");
        mv.addObject("ex",ex);
        mv.setViewName("nameError");
        return mv;
    }
    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception ex){
        //处理NameException的异常
        /*
         * 异常发生处理逻辑：
         * 1、把异常记录下来，记录到数据库，日志文件
         *   记录异常发生的时间，哪个方法发生的，异常错误内容
         * 2、发送通知，把异常的信息通过邮件，短信，微信发送给相关人员
         * 3、给用户友好的提示。
         * */

        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "您的年龄不能大于80");
        mv.addObject("ex",ex);
        mv.setViewName("ageError");
        return mv;
    }

    //处理其他异常，Name和Age以外的未知异常
    //只能有一个
    @ExceptionHandler
    public ModelAndView doOtherException(Exception ex){


        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "未知异常");
        mv.addObject("ex",ex);
        mv.setViewName("defaultError");
        return mv;
    }
}
