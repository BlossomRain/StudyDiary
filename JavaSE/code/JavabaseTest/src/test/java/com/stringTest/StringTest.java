package com.stringTest;

import org.junit.Test;

/**
 * @Auther: lxz
 * @Date: 2020/3/18 0018
 * @Description:测试String类
 */
public class StringTest {
    /**
     * String:字符串,使用""引起来表示
     * 1.final的,不可继承
     * 2.实现了Serializable接口:可序列化
     * Comparable接口:可比较大小
     * 3. private final char value[];
     */
    @Test
    //测试不可变性
    public void test1() {
        String s1 = "abc";  //字面量的定义方式
        String s2 = "abc";
        System.out.println(s1 == s2);
        s2 = "hello";
        System.out.println(s1); //指向相同的引用,s2改变不会改变s1,因为

        String s3 = "java";
        String s4 = "EE";
        String s5 = "java" + "EE";
        System.out.println("javaEE" == s5);
        System.out.println(s3.intern());
    }

    @Test
    //常用方法
    public void test2() {
        String s = "啊啊啊helloworld";
        System.out.println(s.charAt(0));
        System.out.println(s.length());
        System.out.println(s.isEmpty());
        System.out.println(s.toUpperCase());
        System.out.println(s.trim());
        System.out.println(s.equalsIgnoreCase("HELLOWORLD"));
        System.out.println(s.concat(" java"));
        System.out.println(s.compareTo("helloworlc"));
        System.out.println(s.substring(2));
        /**
         h
         10
         false
         HELLOWORLD
         helloworld
         true
         helloworld java
         1
         lloworld*/
    }
}
