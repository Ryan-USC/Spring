package org.example.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


//拦截器类，拦截用户请求
public class MyInterceptor implements HandlerInterceptor {

    private long btime = 0;
    /*
    * 预处理方法
    * 参数：
    *   Obejct handler：被拦截的控制器对象
    * 返回值boolean：
    *   true：通过了拦截器的验证
    *   false：
    *
    * 特点：
    *   1、方法在控制器方法（MyController的doSome）之前执行的。
    *       用户的请求首先到达此方法
    *   2、在这个方法中可以获取请求的信息，验证请求是否符合要求。
    *       可以验证用户是否登录，验证用户是否有权限访问某个链接地址（url）
    *       如果验证失败，可以截断请求，请求不能被处理。
    *       如果请求成功，可以放行请求，此时控制器方法才能执行
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器的预处理方法");
        btime = System.currentTimeMillis();
//        request.getRequestDispatcher("/tips.jsp").forward(request,response);
        return true;
    }


    /*
    * postHandle：后处理方法
    * 参数：
    *   Object handler：被拦截的处理器对象MyController
    *   ModelAndView modelAndView：处理器方法的返回值
    *
    *   特点：
    *   1、在处理器方法执行之后执行的
    *   2、能够获取到处理器方法的返回值ModelAndView，可以修改ModelAndView中的数据和视图，
    *       可以影响到最后的执行结果
    *   3、主要对原来的执行结果进行二次修正
    * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception {
        System.out.println("拦截器的后处理方法");
        // 对原来的doSome执行结果，进行调整

        if (mv != null){
            //修改数据
            mv.addObject("mydate", new Date());
            //修改视图
            mv.setViewName("other");
        }


    }


    /*
    * afterCompletion：最后执行的方法
    * 参数：
    *   Object handler：被拦截的处理器对象MyController
    *   Exception ex：程序中发生的异常
    *
    * 特点：
    *   1、在请求处理完成后执行的。框架中规定是当你的视图处理完成后，对视图进行了forward，可就认为请求处理完成。
    *   2、一般做资源回收工作，程序请求过程中创建了一些对象，在这里可以删除，把占用的内存释放。
    * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器的后处理方法afterCompletion");

        long etime = System.currentTimeMillis();
        System.out.println("时间：" + (etime - btime));
    }
}
