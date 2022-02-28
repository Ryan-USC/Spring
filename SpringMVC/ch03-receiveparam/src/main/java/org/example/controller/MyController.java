package org.example.controller;


import org.example.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
* @@RequestMapping:
*   value：所有请求地址公共部分，叫做模块名称
*   位置：放在类上面
* */
@Controller
public class MyController {
    /*
    * 逐个接收请求参数：
    *   要求：处理器方法的形参名和请求中参数名必须一致。
    *           同名的请求参数赋值给同名的形参
    * 框架接受请求参数
    *   1、使用request对象接收请求的参数
    *       String name = request.getParameter("name")
    *       String age = request.getParameter("age")
    *   2、springmvc框架通过DispatcherServlet调用MyCOntroller的doSome()方法
    *       调用方法时，按名称对应，把接收的参数赋值给形参
    *       doSome(Name, Integer.valueOf(age)
    *       框架会提供类型转换的功能，能把string转为int, long, float, double等。
    *
    *   400状态码是客户端错误，表示提交请求参数过程中，发生了问题。
    * */
    @RequestMapping(value = "/receive.do")
    public ModelAndView doSome(String name, int age){
        // 可以在方法中直接使用name, age
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", name);
        mv.addObject("myAge",age);

        mv.setViewName("show");
        return mv;
    }

    /*
    * 请求中参数名和处理器方法的形参名不一样
    * @RequestParam：解决请求中参数名形参名不一样的问题
    *       属性：1、value 请求中的参数名称
    *            2、required 是一个boolean，默认true
    *                   true表示请求中必须包含此参数
    *       位置：在处理器方法的形参定义上面
    * */
    @RequestMapping(value = "/receiveparam.do")
    public ModelAndView doOther(@RequestParam("rname") String name, @RequestParam("rage") int age){
        // 可以在方法中直接使用name, age
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", name);
        mv.addObject("myAge",age);

        mv.setViewName("show");
        return mv;
    }


    /*
    * 处理器方法形参是java对象，这个对象的属性名和请求参数名是一样的
    * 框架会创建形参的java对象，给属性赋值。请求中的参数是name，框架会调用setName()
    * @return
    * */
    @RequestMapping(value = "/receiveobject.do")
    public ModelAndView receiveObject(Student student){
        System.out.println("reveive parameter, name:" + student.getName() + "   age:" + student.getAge());
        // 可以在方法中直接使用name, age
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", student.getName());
        mv.addObject("myAge",student.getAge());
        mv.addObject("myStudent", student);
        mv.setViewName("show");
        return mv;
    }


}
