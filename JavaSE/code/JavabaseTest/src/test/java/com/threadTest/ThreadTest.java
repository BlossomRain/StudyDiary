package com.threadTest;

import org.junit.Test;

/**
 * @Auther: lxz
 * @Date: 2020/3/16 0016
 * @Description:测试线程的创建和使用
 */
public class ThreadTest {
    public static void main(String[] args) {
        //继承  测试
       /* MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("hello");
        }*/

       //接口实现 测试
        Thread thread = new Thread(new MyThread1());
        thread.start();


    }
}
