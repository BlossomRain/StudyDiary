package com.github.spring.annotation.aop;

import org.springframework.stereotype.Component;

/**
 * @Auther: lxz
 * @Date: 2020/4/8 0008
 * @Description:测试AOP的使用
 */

@Component
public class MathCalculator {
    public int div(int i, int j) {
        System.out.println("div ...");
        return i / j;
    }
}
