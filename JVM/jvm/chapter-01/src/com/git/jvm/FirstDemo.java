package com.git.jvm;

/**
 * 虚拟机发展历程:
 * 1.classic jvm 最早的商用java虚拟机,只携带了解释器
 * 2.Exact jvm  编译加解释混用
 * 3.HotSpot jvm
 */

public class FirstDemo {
    public static void main(String[] args) {
        // 测试反编译
        int i = 0;
        int j = 1;
        int k = i + j;
        /**
         * 1.类初始化以后至少有一个构造器,对应字节码的init方法
         * 2.类变量和赋值操作会被收集到clinit方法中,假如没有类变量,就不会有该方法
         */
    }
}
