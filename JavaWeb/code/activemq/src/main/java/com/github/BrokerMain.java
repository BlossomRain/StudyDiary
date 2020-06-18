package com.github;

import org.apache.activemq.broker.BrokerService;

import java.awt.print.Book;

/**
 * @Auther: lxz
 * @Date: 2020/4/22 0022
 * @Description:
 */
public class BrokerMain {

    public static void main(String[] args) throws Exception {
        //启动嵌入式的borker
        BrokerService brokerService = new BrokerService();
        brokerService.setUseJmx(true);
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.start();
    }

}
