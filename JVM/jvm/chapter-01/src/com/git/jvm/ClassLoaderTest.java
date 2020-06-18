package com.git.jvm;

import sun.misc.Launcher;

import java.net.URL;

public class ClassLoaderTest {
    public static void main(String[] args) {
        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取扩展类加载器
        /**
         * 1.jre/lib/ext下加载,假如放入自己的jar包,也会加载
         * 2.
         */
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println("ext************" + extClassLoader);
        // 打印扩展类加载器可以加载的路径
        String property = System.getProperty("java.ext.dirs");
        for (String s : property.split(";")) {
            System.out.println(s);
        }

        // 获取Bootstrap加载器
        /**
         * 1.c和C++语言实现,
         * 2.jre/lib/rt.jar  resource.jar  或 sun.boot.class.path/* 核心类库
         * 3.
         */
        ClassLoader bootstrap = extClassLoader.getParent();
        System.out.println("bootstrap************" + bootstrap);
        // 打印引导类加载器可以加载的api路径
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL);
        }

        // 获取当前类加载器
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        // 获取String的类加载器===>核心类库都是引导类加载器
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
    }
}
