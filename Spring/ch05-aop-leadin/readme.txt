动态代理：可以在程序的执行过程中，创建代理对象。
通过代理对象执行方法，给目标类的方法增加额外的功能（功能增强）

JDK实现步骤：
1、创建目标类，SomeService目标类，给他的doSome，doOther增加输出时间，事务
2、创建InnovationHandler接口的实现类，在这个类实现给目标方法增加功能。
3、使用jdk中 类proxy创建代理对象，实现创建对象的能力。