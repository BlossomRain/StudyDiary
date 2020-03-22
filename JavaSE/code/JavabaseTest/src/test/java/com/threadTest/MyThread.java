package com.threadTest;

/**
 * @Auther: lxz
 * @Date: 2020/3/16 0016
 * @Description:使用继承方式创建线程子类
 */
public class MyThread extends Thread {
    //输出100 以内的3的倍数
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0)
                System.out.println(i);
        }
    }
}
