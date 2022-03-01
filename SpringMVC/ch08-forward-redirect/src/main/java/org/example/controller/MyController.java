package org.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    * 处理器方法返回ModelAndView，实现转发forward
    * 语法：setViewName("forward:视图文件的完整路径")
    * forward特点：不和视图解析器一同使用，就当项目中没有视图解析器
    * */
    @RequestMapping(value = "/doForward.do")
    public ModelAndView doSome(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun","执行doSome方法");

        // 显示转发
        mv.setViewName("forward:/hello.jsp");
        return mv;
    }


    /*
    * 处理器方法返回ModelAndView，实现转发redirect
    * 语法：serViewName（"redirect:视图完整路径")
    * redirect:不和视图解析器一起使用
    *
    * 框架对重定向的操作：
    * 1、框架会把Model中的简单类型的数据，转为string使用，作为hello.jsp的get请求参数使用。
    *   目的是doRedirect
    * 2、在目标hello.jsp页面可以使用参数集合对象${param}获取请求参数值
    *   ${param.myName}
    * */
    @RequestMapping(value = "/doRedirect.do")
    public ModelAndView doWithRedirect(String name, Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", name);
        mv.addObject("myAge",age);

        // 重定向不能访问WEB-INF资源
        mv.setViewName("redirect:/hello.jsp");
        return mv;
    }

}
