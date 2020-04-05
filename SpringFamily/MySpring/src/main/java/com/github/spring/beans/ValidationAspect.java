package com.github.spring.beans;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Auther: lxz
 * @Date: 2020/4/5 0005
 * @Description:验证参数切面,演示多个切面之间的排序
 */
@Component
@Aspect
@Order(1)
public class ValidationAspect {

    @Before("com.github.spring.beans.LoggingAspect.declareJoinPointExpression()")
    public void validateArgs(JoinPoint joinpoint) {
        System.out.println("validate : " + Arrays.asList(joinpoint.getArgs()));
    }
}
