package com.threadTest;

/**
 * @Auther: lxz
 * @Date: 2020/3/18 0018
 * @Description:
 */
public class TicketWindowExt extends Thread {

    private static int ticket = 100;

    @Override
    public void run() {
        synchronized(TicketWindowExt.class){
            while (ticket >= 1) {
                System.out.println(Thread.currentThread().getName() +
                        "\tticket left " + ticket--);

            }
        }
    }
}
