package com.threadTest;

/**
 * @Auther: lxz
 * @Date: 2020/3/18 0018
 * @Description:测试线程安全问题
 */
public class TicketTest {
    public static void main(String[] args) {
        //testTicketImpl();       //实现方式 同步代码块
        testTicketExt();       //继承方式 同步代码块
    }


    public static void testTicketImpl() {
        Thread thread = null;
        TicketWindowImpl ticketWindow = new TicketWindowImpl();
        for (int i = 0; i < 3; i++) {
            thread = new Thread(ticketWindow);
            thread.start();
        }

    }

    public static void testTicketExt() {
        for (int i = 0; i < 3; i++){
            new TicketWindowExt().start();
        }
    }
}
