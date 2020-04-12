package com.github.spring.annotation.config;

import com.github.spring.annotation.aop.MathCalculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: lxz
 * @Date: 2020/4/8 0008
 * @Description:
 */
public class AOPConfigTest {

    ApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);

    @Test
    public void testAOP() {
        MathCalculator bean = ctx.getBean(MathCalculator.class);
        bean.div(1, 1);
    }


}