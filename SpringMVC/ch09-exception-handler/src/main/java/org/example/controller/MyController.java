package org.example.controller;


import org.example.exception.AgeException;
import org.example.exception.MyUserException;
import org.example.exception.NameException;
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
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name, Integer age) throws MyUserException {
        ModelAndView mv = new ModelAndView();

        //根据请求参数抛出异常
        if (!"zhangsan".equals(name)){
            throw new NameException("姓名不正确");
        }
        if (age == null || age > 80){
            throw new AgeException("年龄比较大");
        }
        mv.addObject("myName", name);
        mv.addObject("myAge",age);

        // 显示转发
        mv.setViewName("show");
        return mv;
    }



}
