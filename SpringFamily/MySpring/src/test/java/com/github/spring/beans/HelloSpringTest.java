package com.github.spring.beans;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Auther: lxz
 * @Date: 2020/4/4 0004
 * @Description:
 */
public class HelloSpringTest {

    @Test
    public void sayHello() {
        //IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //利用id直接获取
//        HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
        //利用类型获取,可能会有多个结果
        HelloSpring bean = context.getBean(HelloSpring.class);
//        helloSpring.sayHello();

    }
}