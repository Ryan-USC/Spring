ch04-return: 处理器方法的返回值表示请求的处理结果
1、ModelAndView：有数据和视图，对视图执行forward
2、String：表示视图，可以逻辑名称，也可以是完整的视图路径
3、void：不能表示数据，也不能表示视图
    在处理ajax的时候，可以使用void。通过HttpServletResponse输出数据。相应ajax请求。
    ajax请求服务器端返回的就是数据，和视图无关。
4、Object：例如String，Integer，Map，，List，Student都是对象。
    对象有属性，属性是数据。返回Object表示数据，与视图无关。
    可以使用对象表示的数据，相应ajax请求。

    现在做ajax，主要使用json的数据格式。
    1、加入处理json工具库的依赖，springmvc默认使用的jackson
    2、在springmvc的配置文件中加入<mvc:annotation-driven>注解驱动。
    3、在处理器方法上面加入@ResponseBody注解

    springmvc处理器方法返回Object，可以转为json输出浏览器，响应ajax的内部原理
    1、<mvc:annotation-driven>注解驱动
        注解驱动实现的功能是 完成java对象到json，xml，text，二进制等数据格式的转换。
        <mvc:annotation-driven>在加入到springmvc配置文件中，会自动创建HttpMessageConverter接口
        的7个实现类对象，包括 MappingJackson2HttpMessageConverter（使用jackson工具库中的ObjectMapper实现java对象转为json

        HttpMessageConverter接口：消息转换器。
        功能：定义了java转为json，xml等数据格式的方法。这个接口有很多实现类。
            这些实现类完成 java对象到json，xml，二进制数据的转换。

        下面两个方法是控制器把结果输出给浏览器时使用的：
        boolean canWrite(Class<?> var1, @Nullable MediaType var2);
        void write(T var1, @Nullable MediaType var2, HttpOutputMessage var3)

        1）canWrite作用急哦安插处理器方法的返回值，能不能转为var2表示的数据格式
            检查student（lisi，20）能不能转为var2表示的数据格式。如果检查能成为json，canWrite返回true
            MediaType：表示数据格式的，例如json，xml等
        2）write：把处理器方法的返回值对象，调用jackson中的ObjectMapper转为json字符串。
            json = om.writeValueAsString(student);
    2、@ResponseBody注解
        放在处理器方法的上面，通过HttpServletResponse输出数据，相应ajax



注意：
    在提交请求参数时，get请求方式中文没有乱码。
    使用post方式提交请求，中文有乱码，需要使用过滤器处理乱码问题。

过滤器可以自定义，也可以使用框架提供的过滤器 CharacterEncodingFilter
实现步骤：
1、新建web maven工程
2、加入依赖
    spring-webmvc依赖，间接把spring的依赖都加入到项目
    jsp，servlet依赖
3、重点：在web.xml中注册springmvc框架的核心对象DispatcherServlet
    1）DispatcherServlet中央调度器，是一个Servlet，它的父类是继承HttpServlet
    2）DispatcherServlet也叫做前端控制器（front controller）
    3）DispatcherServlet负责接受用户提交的请求，调用其他的控制器对象，
                        并把请求的处理结果显示给用户
4、创建一个发起请求的页面 index.jsp

5、创建控制器类
    1）在类的上面加入@Controller注解，创建对象，并放入到springmvc容器中
    2）在类中方法上面加入@RequestMapping注解

6、创建一个作为结果的jsp，显示请求的处理结果

7、创建springmvc的配置文件（spring的配置文件一样）
    1）声明组件扫描器，指定@Controller注解所在的包名
    2）声明视图解析器，帮助处理视图。