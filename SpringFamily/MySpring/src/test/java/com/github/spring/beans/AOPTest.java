package com.github.spring.beans;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: lxz
 * @Date: 2020/4/5 0005
 * @Description:
 */
public class AOPTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");

    //测试前置后置方法注解
    @Test
    public void testBeforAfter(){

        ArithmeticCalculator ari = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
        int add = ari.add(1, 1);
        System.out.println(add);
    }

}
