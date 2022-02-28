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
@RequestMapping("/test")
public class MyController {
    /*
    * @RequestMapping:请求映射
    *               属性：method，表示请求的方式。它的值RequestMethod类枚举值。
    *                   例如：表示get请求方式，RequestMethod.GET
    *
    *   HTTP Status 405 如果请求方式不匹配
    * */
    //指定some.do使用get请求方式
    @RequestMapping(value = {"/some.do", "/first.do"}, method = RequestMethod.GET)
    public ModelAndView doSome(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun","执行doSome方法");

        mv.setViewName("show");
        return mv;
    }
    // z指定other.do是post请求方式
    @RequestMapping(value = {"/other.do", "/second.do"},method = RequestMethod.POST)
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun","执行doOther方法");

        mv.setViewName("other");
        return mv;
    }

    // 不指定请求方式
    @RequestMapping(value = "first.do")
    public ModelAndView doFirst(HttpServletRequest request,
                                HttpServletResponse response,
                                HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun","执行doFirst方法" + request.getParameter("name"));

        mv.setViewName("other");
        return mv;
    }


}
