package com.threadTest;

/**
 * @Auther: lxz
 * @Date: 2020/3/18 0018
 * @Description: 同步问题
 */
public class TicketWindowImpl implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {

        synchronized(this){
            while (ticket >= 1) {
                System.out.println(Thread.currentThread().getName() +
                        "\tticket left " + ticket--);

            }
        }
    }
}
