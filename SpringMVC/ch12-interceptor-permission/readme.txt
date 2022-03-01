ch12-interceptor-permission

异常处理步骤：
1、新建maven web项目
2、修改web.xml注册中央调度器
3、新建index.jsp发起请求
4、创建MyController处理请求
5、创建结果show.jsp
6、创建一个login.jsp，模拟登录（把用户信息放入到session）
    创建一个jsp，logout.jsp模拟退出系统（从session删除数据）
7、创建拦截器，从session中获取用户的登录数据，验证能否登录系统
8、创建一个验证jsp，如果验证视图，给出提示
9、创建springmvc的配置文件
    声明组件扫描器
    声明拦截器


