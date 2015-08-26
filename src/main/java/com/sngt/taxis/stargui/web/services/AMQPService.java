package com.sngt.taxis.stargui.web.services;

import com.sngt.taxis.stargui.web.domain.amqp.TG7Message;
import com.sngt.taxis.stargui.web.domain.amqp.TG7MessageUtils;
import com.sngt.taxis.stargui.web.domain.messages.ACKEntity;
import com.sngt.taxis.stargui.web.services.amqp.AMQPClient;
import com.sngt.taxis.stargui.web.services.amqp.AMQPDataParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yvu on 17/08/2015.
 */
@Component
public class AMQPService {

    public static final Logger LOGGER = LoggerFactory.getLogger(AMQPService.class);

    private final String hostname;
    private final String port;
    private final String login;
    private final String password;
    private final Integer messageTTL;
    private final Map<String, AMQPClient> amqpClients;

    @Autowired
    AMQPDataParser amqpDataParser;

    @Autowired
    public AMQPService(@Value("${amqp.hostname}") String hostname, @Value("${amqp.port}") String port,
                       @Value("${amqp.login}") String login, @Value("${amqp.password}") String password,
                       @Value("${amqp.messageTTL}") Integer messageTTL) {
        this.hostname = hostname;
        this.port = port;
        this.login = login;
        this.password = password;
        this.messageTTL = messageTTL;
        amqpClients = new HashMap<>();
    }

    private AMQPClient get(String channel) {
        LOGGER.info("connecting to queue : [{}]", channel);
        AMQPClient amqpClient = amqpClients.get(channel);
        if (amqpClient == null) {
            amqpClient = new AMQPClient(hostname, port, channel, login, password, amqpDataParser);
            amqpClients.put(channel, amqpClient);
        }
        return amqpClient;
    }

    public void produceMessage(final String channel, final String message) {
        get(channel).processAndPublishMessage(message, AMQPClient.NO_SEQUENCE);
    }

    public void produceMessage(final String channel, final String message, final Long nextPublishSeqNo) {
        get(channel).processAndPublishMessage(message, nextPublishSeqNo);
    }

    public void startConsuming(final String channel) {
        get(channel).startConsumingOnQueue(messageTTL);
    }

    public void stopConsuming(final String channel) {
        get(channel).stopConsumingOnQueue();
    }

    @PreDestroy
    public void cleanUp() throws Exception {
        amqpClients.values().stream().forEach(c -> c.stopConsumingOnQueue());
    }

    public void ackMessage(String channel, long ackWSMessageType) {
        final ACKEntity ackEntity = new ACKEntity();
        ackEntity.setACKMessageType(ackWSMessageType);
        amqpDataParser.convertToMessage(ackEntity);
        TG7Message message = new TG7Message();
        message.setEntity(ackEntity);
        get(channel).processAndPublishMessage(TG7MessageUtils.buildBrokerMessage(message), AMQPClient.NO_SEQUENCE);
    }
}
