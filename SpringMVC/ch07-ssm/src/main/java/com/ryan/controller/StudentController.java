package com.ryan.controller;

import com.ryan.domain.Student;
import com.ryan.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService service;

    // 注册学生
    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student){
        String tips = "注册失败";
        // 调用service处理student
        int nums = service.addStudent(student);
        if (nums > 0){
            // 注册成功
            tips = "学生" + student.getName() + "注册成功";
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("tips",tips);
        mv.setViewName("result");
        return mv;
    }

    //处理查询，相应ajax
    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudents(){
        List<Student> students = service.findStudents();
        return students;
    }
}
