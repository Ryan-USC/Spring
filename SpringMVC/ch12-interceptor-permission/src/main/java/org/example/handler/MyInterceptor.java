package org.example.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;



public class MyInterceptor implements HandlerInterceptor {

    // 验证登录的用户信息，正确返回true
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("11111拦截器的预处理方法");
        String loginName = "";

        Object attr = request.getSession().getAttribute("name");
        if (attr != null){
            loginName = (String) attr;
        }
        if (!"zs".equals(loginName)) {
            request.getRequestDispatcher("/tips.jsp").forward(request, response);
            return false;
        }
        return true;
    }

}
