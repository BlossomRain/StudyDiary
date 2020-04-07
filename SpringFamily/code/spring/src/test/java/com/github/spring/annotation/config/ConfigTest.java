package com.github.spring.annotation.config;

import com.github.spring.annotation.bean.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import static org.junit.Assert.*;

/**
 * @Auther: lxz
 * @Date: 2020/4/7 0007
 * @Description:测试用配置类的方式使用spring
 */
public class ConfigTest {
    //获取IOC容器对象
    private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

    //测试条件注入
    @Test
    public void testConditional(){
        Object conditionalPerson = ctx.getBean("conditionalPerson");
        System.out.println(conditionalPerson);
        Object colorFactoryBean = ctx.getBean("colorFactoryBean");
        System.out.println(colorFactoryBean.getClass());
        Object colorFactoryBean2 = ctx.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean2.getClass());
    }

    //测试Scope
    @Test
    public void testScope(){
        Object person = ctx.getBean("person");
        Object person2 = ctx.getBean("person");
        System.out.println(person == person2);
    }


    //获取第一个bean
    @Test
    public void testPerson() {
        Person bean = ctx.getBean(Person.class);
        System.out.println(bean);
        bean = (Person) ctx.getBean("person");
        System.out.println(bean);
        //获取受管理的类
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String s : beanDefinitionNames) {
            System.out.println(s);
        }
    }

}