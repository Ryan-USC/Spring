package org.example.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


public class MyInterceptor2 implements HandlerInterceptor {

    private long btime = 0;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("22222拦截器的预处理方法");
        btime = System.currentTimeMillis();

        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception {
        System.out.println("2222拦截器的后处理方法");
        // 对原来的doSome执行结果，进行调整

        if (mv != null){
            //修改数据
            mv.addObject("mydate", new Date());
            //修改视图
            mv.setViewName("other");
        }
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("2222拦截器的后处理方法afterCompletion");

        long etime = System.currentTimeMillis();
        System.out.println("222时间：" + (etime - btime));
    }
}
