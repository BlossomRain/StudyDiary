package com.github.spring.annotation.bean;

/**
 * @Auther: lxz
 * @Date: 2020/4/7 0007
 * @Description:测试Bean的生命周期
 */
public class Car {

    public Car() {
        System.out.println("Car Constructor....");
    }

    public void init() {
        System.out.println("Car init....");
    }

    public void destroy() {
        System.out.println("Car destroy....");
    }
}
