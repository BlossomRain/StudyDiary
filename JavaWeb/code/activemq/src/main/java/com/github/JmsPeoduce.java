package com.github;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.jms.*;

/**
 * @Auther: lxz
 * @Date: 2020/4/21 0021
 * @Description:
 */
public class JmsPeoduce {
    public static final String ACTIVEMQ_URL = "tcp://192.168.18.128:61616";
    public static final String QUEUE_NAME = "queue-1";
    private static final String TOPIC_NAME = "topic-1";

    ActiveMQConnectionFactory factory;
    Session session;
    Connection connection;
    Queue queue;
    Topic topic;

    @Test
    public void testTopicConsumer() throws JMSException {
        MessageConsumer consumer = session.createConsumer(topic);
        Message receive = consumer.receive();
        //将queue替换成topic即可
    }
    
    
    @Test
    public void testTopicProducer(){
        
    }
    

    @Test
    public void testConsumerByListener() throws Exception {
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(msg->{
            if (null != msg && msg instanceof TextMessage){
                TextMessage message = (TextMessage) msg;
                try {
                    System.out.println(message.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.in.read();
        consumer.close();
    }
    
    
    @Test//阻塞等待
    public void testConsumer() throws JMSException {
        MessageConsumer consumer = session.createConsumer(queue);
        label:
        while (true) {
            TextMessage message = (TextMessage) consumer.receive();
            if (message != null) {
                System.out.println(message.getText());
            } else {
                break label;
            }
        }
        consumer.close();
    }


    @Test
    public void testProducer() throws JMSException {
        MessageProducer producer = session.createProducer(queue);
        for (int i = 0; i < 2; i++) {
            TextMessage textMessage = session.createTextMessage("msg--->" + i + 1);

            producer.send(textMessage);
        }

    }


    @Before
    public void before() throws JMSException {

        //创建连接工厂
        factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        connection = factory.createConnection();
        connection.start();

        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        queue = session.createQueue(QUEUE_NAME);
        topic = session.createTopic(TOPIC_NAME);

    }

    @After
    public void after() throws JMSException {
        session.close();
        connection.close();
    }

}
