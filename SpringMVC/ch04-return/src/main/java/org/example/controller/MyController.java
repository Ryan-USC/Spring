package org.example.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/*
* @@RequestMapping:
*   value：所有请求地址公共部分，叫做模块名称
*   位置：放在类上面
* */
@Controller
public class MyController {
    /*
    * 处理器方法返回String--表示逻辑视图名称，需要配置视图解析器
    * */
    @RequestMapping(value = "/returnString-view.do")
    public String doReturnView(HttpServletRequest request, String name, int age){
        // 可以在方法中直接使用name, age
        System.out.println("doReturnView" + name + ", " + age);
        request.setAttribute("myName", name);
        request.setAttribute("myAge", age);
        // 可以手工加入数据到request作用域
        // show 是逻辑视图名称，项目中配置了视图解析器
        // 框架对视图执行了forward操作
        return "show";
    }


    // 处理器返回String，表示视图完整路径，此时不能配置视图解析器
    @RequestMapping(value = "/returnString-view2.do")
    public String doReturnView2(HttpServletRequest request, String name, int age){
        // 可以在方法中直接使用name, age
        System.out.println("===doReturnView2===" + name + ", " + age);
        request.setAttribute("myName", name);
        request.setAttribute("myAge", age);
        // 完整视图路径，项目中不能配置视图解析器
        // 框架对视图执行了forward操作
        return "/WEB-INF/view/show.jsp";
    }


    // 处理器返回void,相应ajax请求
    // 手工实现ajax，json数据，
    @RequestMapping(value = "/returnVoid-ajax.do")
    public void doReturnVoidAjax(HttpServletResponse response, String name, Integer age) throws IOException {
        // 可以在方法中直接使用name, age
        System.out.println("===doReturnVoidAjax===" + name + ", " + age);

        // 处理ajax，使用json做数据的格式
        // service调用完成了，使用Student表示处理结果
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        String json = "";
        if (student != null){
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(student);
            System.out.println("student转换的json" + json);
        }
        // 输出数据，相应ajax的请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }

    /*
    * 处理器方法返回一个Student，通过框架转为json，相应ajax
    * @ResponseBody
    *   作用：把处理器返回对象转为json，通过HttpServletResponse输出给浏览器
    *   位置：方法的定义上面，和其他注解没有先后顺序
    * 返回对象框架的处理流程：
    *   1、框架会把返回Student类型，调用框架中ArrayList<>每个类中的canWrite()方法
    *   检查哪个HttpMessageConverter接口的实现类能处理Student类型的数据
    *   2、框架会调用实现类的write(); MappingJackson2HttpMessageConverter的write方法
    *   3、框架会调用ResponseBody功能把2的结果输出到浏览器，ajax请求处理完成
    * */
    @RequestMapping(value = "/returnStudentJson.do")
    @ResponseBody
    public Student doStudentJsonObject(String name, Integer age){
        //调用service，获取请求结果数据，Student对象表示结果数据
        Student student = new Student();
        student.setAge(20);
        student.setName("lisi");
        return student;
    }

    /*
    *   处理器方法返回List<Student>
    * */
    @RequestMapping(value = "/returnStudentJsonArray.do")
    @ResponseBody
    public List<Student> doStudentJsonArray(String name, Integer age){
        //调用service，获取请求结果数据，Student对象表示结果数据
        List<Student> list = new LinkedList<>();
        Student student = new Student();
        student.setAge(20);
        student.setName("lisi");
        list.add(student);
        student = new Student();
        student.setName("jay");
        student.setAge(22);
        list.add(student);
        return list;
    }

    /*
    * 处理器方法返回的是String，String表示数据，不是视图
    * 区分返回值是数据还是视图，看有没有@ResponseBody
    * 如果有@ResponseBody返回数据，否则返回视图
    *
    * 默认使用"text/plain;charset=ISO-8859-1"，导致中文乱码
    * 解决方案：给RequestMapping增加一个属性produces,使得这个属性指定新的content Type
    * */
    @RequestMapping(value = "/returnStringData.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String doStringData(String name, Integer age){

        return "Hello SpringMVC 返回对象，表示数据";
    }


}
