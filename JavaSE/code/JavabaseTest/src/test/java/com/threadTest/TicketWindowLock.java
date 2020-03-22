package com.threadTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: lxz
 * @Date: 2020/3/18 0018
 * @Description:jdk5.0 lock同步
 */
public class TicketWindowLock implements Runnable {

    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {


        while (ticket >= 1) {
            try {
                //加锁
                lock.lock();

                System.out.println(Thread.currentThread().getName() +
                        "\tticket left " + ticket--);
            } finally {
                //解锁
                lock.unlock();
            }

        }

    }
}
