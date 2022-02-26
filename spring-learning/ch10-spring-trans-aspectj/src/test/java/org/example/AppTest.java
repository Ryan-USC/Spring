package org.example;

import static org.junit.Assert.assertTrue;

import org.example.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AppTest 
{

    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        BuyGoodsService service = (BuyGoodsService) ctx.getBean("buyService");

        System.out.println(service.getClass().getName());
        service.buy(1001, 10);
    }
}
