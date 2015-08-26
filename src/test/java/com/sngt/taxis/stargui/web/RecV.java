package com.sngt.taxis.stargui.web;

import com.rabbitmq.client.*;
import org.springframework.util.SerializationUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yvu on 11/08/2015.
 */
public class RecV {

    private final static String QUEUE_NAME = "1234";
    public static final String HOST = "172.27.20.22";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setUsername("tg7dev");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("dispatchExchange", "direct", false);
        channel.exchangeDeclare("deadLetterExchange", "direct", false);
        final Map<String, Object> args = new HashMap<>();
        if ("dispatch".equals(QUEUE_NAME)) {
            args.put("x-max-length", 100);
        }
        else {
            args.put("x-message-ttl", 30000);
            args.put("x-dead-letter-exchange", "deadLetterExchange");
            args.put("x-dead-letter-routing-key", "dead-letter-routing-key");
        }
        final AMQP.Queue.DeclareOk declaredQueue = channel.queueDeclare(QUEUE_NAME, false, false, false, args);
        channel.queueBind(declaredQueue.getQueue(), "dispatchExchange", declaredQueue.getQueue());
//        if ("dispatch".equals(QUEUE_NAME)) {
            channel.queueBind(declaredQueue.getQueue(), "deadLetterExchange", "dead-letter-routing-key");
//        }
//        channel.queueBind(declaredQueue.getQueue(), "dispatchExchange", "#");
//        channel.queueBind(declaredQueue.getQueue(), "deadLetterExchange", "#");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                System.out.println("handleDelivery");
                String message = (String) SerializationUtils.deserialize(body);
                System.out.println(" [x] Received '" + message + "'");
            }


        };
//        channel.basicConsume(QUEUE_NAME, true, consumer);
        channel.basicConsume(QUEUE_NAME, true, "a", consumer);
    }
}
