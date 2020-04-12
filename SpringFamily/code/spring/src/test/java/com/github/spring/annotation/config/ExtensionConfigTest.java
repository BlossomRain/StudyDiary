package com.github.spring.annotation.config;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.EventListener;

/**
 * @Auther: lxz
 * @Date: 2020/4/8 0008
 * @Description:
 */
public class ExtensionConfigTest {

    private ApplicationContext ctx = new AnnotationConfigApplicationContext(ExtensionConfig.class);

    @Test
    public void testBeanFactoryPostProcessor(){


    }


}