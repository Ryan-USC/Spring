ch07-ssm: SSM整合开发
SSM：SpringMVC + Spring + MyBatis

SpringMVC：视图层，界面层，负责接收请求，显示处理结果
Spring：业务层，管理service，dao，工具类对象
MyBatis：持久层，访问数据库

用户发起请求--springMVC接收---spring中的Service对象--MyBatis处理数据

SSM整合也叫做做SSI（IBatis也就是MyBatis的前身），整合中有容器。
1、第一个容器叫做springMVC容器，管理Controller控制器对象的。
2、第二个容器Spring容器，管理Service，Dao，工具类对象。
我们要做的是把使用的对象交给合适的容器创建，管理。把Controller还有web开发的相关对象
交给springMVC容器，这些web用的对象写在springmvc配置文件中。

service，dao对象定义在spring的配置文件中，让spring管理这些对象。

springmvc容器和spring容器是有关系的，关系已经确定好了。
springmvc容器是spring容器的子容器，类似于java中的继承。子可以访问父的内容。
在子容器中的Controller可以访问父容器中的Service对象，就可以实现Controller使用Service对象。

步骤：
0、使用SpringDb的mysql库，表使用student（id auto_increment,name,age)
1、新建maven web项目
2、加入依赖
    springmvc, spring, mybatis三个框架的依赖，jackson依赖，mysql驱动，druid连接池，jsp，servlet依赖
3、写web.xml
    1）注册DispatcherServlet，目的：1、创建springmvc容器对象，才能创建Controller类对象。
                                  2、创建得是Servlet，才能接收用户的请求
    2）注册spring的监听器：ContextLoaderListener，目的：创建spring的容器对象，才能创建service，dao等对象

    3）注册字符集过滤器，解决post请求乱码的问题
4、创建包，Controller包，service，dao，实体类

5、写配置文件
    1）springmvc配置文件
    2）spring配置文件
    3）mybatis配置文件
    4）数据库配置文件
6、代码
7、jsp