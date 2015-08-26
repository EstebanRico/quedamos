package com.sngt.taxis.stargui.web;

import com.google.common.base.Charsets;
import com.rabbitmq.client.*;
import org.junit.Test;
import org.springframework.util.SerializationUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * Created by yvu on 11/08/2015.
 */
public class AMQPClientTests {

    //    private final static String QUEUE_NAME = "dispatch";
    private final static String DISPATCH_QUEUE_NAME = "dispatch";
    private final static String MID_QUEUE_NAME = "1234";
    public static final String HOST = "172.27.20.22";
    public static final char START_OF_HEADING = 1;
    public static final char END_OF_TEXT = 3;


    //^A0B5010929D221300{"i":"1234","an":"12","st":"17","sn":"rue de l'echiquier","c":"Paris","d":"","ct":"","ats":[],"tg":30,"mh":"","rp":fals
    //e,"cmt":"","rf":false,"pr":false,"wc":false}^C

    class Star2015Message {
        private final long mid;
        private final long id;
        private final String body;
        private final long resp;
        private final String type;

        public Star2015Message(String body, long mid, long id, long resp, String type) {
            this.body = body;
            this.mid = mid;
            this.id = id;
            this.resp = resp;
            this.type = type;
        }

        public String getBody() {
            return body;
        }

        public long getId() {
            return id;
        }

        public long getMid() {
            return mid;
        }

        public long getResp() {
            return resp;
        }

        public String getType() {
            return type;
        }

        public String convertToBrokerMessage() {
            final StringBuilder sb = new StringBuilder();
            sb.append(START_OF_HEADING);
            sb.append(String.format("%03X", getBody().getBytes(Charsets.UTF_8).length + 3 + 5 + 2 + 2 + 2));
            sb.append(String.format("%05X", getMid()));
            sb.append(String.format("%02X", getId()));
            sb.append(getType());
            sb.append(String.format("%02X", getResp()));
            sb.append(body);
            sb.append(END_OF_TEXT);
            return sb.toString();
        }

    }



    @Test
    public void namelesstest() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(HOST);
            factory.setUsername("tg7dev");
            factory.setPassword("admin");
            final Connection connection = factory.newConnection();
            final Channel channel = connection.createChannel();
//            createAndBindConsumerQueue(channel, DISPATCH_QUEUE_NAME, 30000);
//            createAndBindConsumerQueue(channel, MID_QUEUE_NAME, 30000);

            final String jsonBody = "{\"loc\":{\"L\":0,\"l\":1,\"d\":1111},\"t\":0,\"s\":1000,\"c\":1223333,\"stv\":\"2015.1\",\"syv\":\"2.3\",\"sydv\":\"2.22\",\"cv\":\"122\",\"tpev\":\"0.2\"}";
            final String SignIn = "2100";
            final long noResponse = 0L;
            final Star2015Message star2015Message = new Star2015Message(jsonBody, 1234L, 42L, noResponse, SignIn);

            String message = star2015Message.convertToBrokerMessage();
//            channel.basicPublish("dispatchExchange", QUEUE_NAME, new AMQP.BasicProperties().builder().build(), SerializationUtils.serialize(message));
            channel.basicPublish("dispatchExchange", DISPATCH_QUEUE_NAME, new AMQP.BasicProperties().builder().build(), SerializationUtils.serialize(message));
            System.out.println(" [x] Sent '" + message + "'");

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    System.out.println("handleDelivery");
                    String message = (String) SerializationUtils.deserialize(body);
                    System.out.println(" [x] Received '" + message + "'");
                }
            };
            channel.basicConsume(MID_QUEUE_NAME, true, "a", consumer);
            new Thread() {
                public void run() {
                    try {
                        Thread.sleep(30000);
                        channel.close();
                        connection.close();
                    } catch (IOException | TimeoutException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        } catch (TimeoutException | IOException e) {
            e.printStackTrace();
        }
    }

}