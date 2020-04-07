package com.github.spring.beans;

/**
 * @Auther: lxz
 * @Date: 2020/4/4 0004
 * @Description:初次体验spring的bean管理
 */
public class HelloSpring {

    private String name;

    public HelloSpring() {
        System.out.println("this is HelloSpring Constructor..");
    }

    public void setName(String name) {
        System.out.println("this is setName...");
        this.name = name;
    }

    public void sayHello() {
        System.out.println("hello..." + name);
    }
}
