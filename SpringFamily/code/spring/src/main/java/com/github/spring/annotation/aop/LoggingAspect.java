package com.github.spring.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Auther: lxz
 * @Date: 2020/4/8 0008
 * @Description:切面编程
 */
@Component
@Aspect
public class LoggingAspect {

    //抽取切入点表达式
    @Pointcut("execution(public int MathCalculator.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println("logStart..." + Arrays.asList(joinPoint.getArgs()));
    }

    @After("pointCut()")
    public void logEnd() {
        System.out.println("logEnd...");
    }

    @AfterReturning(value = "pointCut()", returning = "res")
    public void logReturn(int res) {
        System.out.println("logReturn..." + res);
    }

    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void logException(Exception ex) {
        System.out.println("logException..." + ex.getMessage());
    }
}
