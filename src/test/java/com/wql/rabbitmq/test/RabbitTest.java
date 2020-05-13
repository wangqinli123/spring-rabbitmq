package com.wql.rabbitmq.test;

import com.wql.rabbitmq.producer.MessageProducer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RabbitTest {

    private ApplicationContext context = null;

    @Test
    public void sendMessage(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //getBean("类名首字母小写"),
        MessageProducer messageProducer = (MessageProducer)context.getBean("messageProducer");
        int k = 100;
        while (k>0){
            messageProducer.sendMessage("第" + k + "次发送的消息");
            k--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
