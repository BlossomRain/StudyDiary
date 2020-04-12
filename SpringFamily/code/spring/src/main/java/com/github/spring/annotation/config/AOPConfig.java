package com.github.spring.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Auther: lxz
 * @Date: 2020/4/8 0008
 * @Description:测试AOP的使用
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value = {"com.github.spring.annotation.aop"})
public class AOPConfig {
}
