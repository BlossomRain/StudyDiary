package com.threadTest;

/**
 * @Auther: lxz
 * @Date: 2020/3/17 0017
 * @Description:用Runnable实现的方式 多线程
 */
public class MyThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0)System.out.println(i);
        }
    }
}
