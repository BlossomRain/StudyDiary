package com.github.spring.beans;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: lxz
 * @Date: 2020/4/4 0004
 * @Description:
 */
public class PersonTest {
    //测试属性配置的一些细节
    @Test
    public void test() {
        ApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) con.getBean("person");
        System.out.println(person);
        System.out.println(person.getCar());
    }


}