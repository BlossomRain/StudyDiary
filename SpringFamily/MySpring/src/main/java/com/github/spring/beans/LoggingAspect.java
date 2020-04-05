package com.github.spring.beans;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: lxz
 * @Date: 2020/4/5 0005
 * @Description:日志切面
 */

//声明为一个切面,并由IOC进行管理
@Component
@Aspect
@Order(2)
public class LoggingAspect {

    //重用切入点表达式: 定义一个空方法用于声明表达式
    @Pointcut("execution(* com.github.spring.beans.ArithmeticCalculator.*(..))")
    public void declareJoinPointExpression() {}


    //声明该方法在哪些类那些方法前面执行
    @Before("declareJoinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        //获取方法名称 和 参数
        String name = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + name + " begins with " + args);
    }

    //声明该方法在哪些类那些方法后面执行  无论该方法是否发生异常
    @After("declareJoinPointExpression()")
    public void afterMethod(JoinPoint joinPoint) {
        //获取方法名称 和 参数
        String name = joinPoint.getSignature().getName();
        System.out.println("The method " + name + " ends ");
    }

    //声明该方法在哪些类那些方法  正常结束  后面执行
    @AfterReturning(value = "declareJoinPointExpression()",
            returning = "result")
    public void afterReturn(JoinPoint joinPoint, Object result) {
        //获取方法名称 和 参数
        String name = joinPoint.getSignature().getName();

        System.out.println("The method " + name + " ends with " + result);
    }
}
