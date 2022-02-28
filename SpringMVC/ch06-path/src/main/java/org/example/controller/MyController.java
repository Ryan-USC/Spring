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
@RequestMapping("/user")
public class MyController {

    @RequestMapping(value = "/some.do", method = RequestMethod.GET)
    public ModelAndView doSome(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun","执行doSome方法");

        mv.setViewName("show");
        return mv;
    }

}
