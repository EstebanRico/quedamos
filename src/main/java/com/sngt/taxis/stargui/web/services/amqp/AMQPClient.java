package com.sngt.taxis.stargui.web.services.amqp;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import com.sngt.taxis.stargui.web.domain.amqp.TG7MessageUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yvu on 14/08/2015.
 */
public class AMQPClient extends AMQPEndPoint implements Consumer {

    private static final String X_MAX_LENGTH = "x-max-length";
    private static final int DISPATCH_QUEUE_MAX_LENGTH = 100;
    private static final boolean IS_EXCHANGE_DURABLE = false;
    private static final boolean IS_AUTO_DELETE = false;
    private static final boolean IS_AUTO_ACK = true;
    private static final boolean IS_EXCLUSIVE = false;
    private static final boolean IS_QUEUE_DURABLE = false;
    public static final boolean IS_USE_SSL = false;
    public static final boolean AUTO_RECONNECT = true;
    private boolean consuming;
    public static final String DISPATCH_QUEUE = "dispatch";
    public static final String DEFAULT_EXCHANGE = "dispatchExchange";
    public static final String DLX = "deadLetterExchange";
    public static final String DLX_ARG = "x-dead-letter-exchange";
    public static final String X_DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";
    public static final String DEAD_LETTER_ROUTING_KEY = "dead-letter-routing-key";
    public static final String X_MESSAGE_TTL = "x-message-ttl";
    private static final String CONSUMER_TAG = "a";
    private static final String EXCHANGE_TYPE = "direct";
    private static final Logger LOGGER = LoggerFactory.getLogger(AMQPClient.class);
    public static final Long NO_SEQUENCE = null;
    private String consumingQueueName;
    private AMQP.Queue.DeclareOk declaredQueue;
    private AMQPDataParser listener;

    public AMQPClient(String hostname, String port,
                      String queue, String login, String password, AMQPDataParser amqpDataParser) {
        super(hostname, port, IS_USE_SSL, AUTO_RECONNECT);
        connect(queue, login, password);
        listener = amqpDataParser;
    }

    @Override
    public void handleCancel(final String consumerTag) throws IOException {
        LOGGER.debug("handleCancel : {}", consumerTag);
    }

    @Override
    public void handleCancelOk(final String consumerTag) {
        LOGGER.debug("handleCancelOk : {}", consumerTag);
    }

    @Override
    public void handleConsumeOk(final String consumerTag) {
        LOGGER.debug("handleConsumeOk : {}", consumerTag);
    }

    @Override
    public void handleDelivery(final String consumerTag, final Envelope envelope, final AMQP.BasicProperties properties, final byte[] message) throws IOException {
        LOGGER.debug("handleDelivery : {}", consumerTag);
        notifyDataReceive(envelope, properties, message, null);
    }

    @Override
    public void handleRecoverOk(final String consumerTag) {
        LOGGER.debug("handleRecoverOk : {}", consumerTag);
    }

    @Override
    protected void handlePublisherConfirm(final long totalTimeMillis) {
        LOGGER.debug("handlePublisherConfirm in total [{} ms]: ", totalTimeMillis);
    }

    @Override
    public void handleShutdownSignal(final String arg0, final ShutdownSignalException arg1) {
        LOGGER.debug("Connection lost to broker " + arg0 + " \n" + arg1);
        stopConsumingOnQueue();
    }

    @Override
    public void disConnect() {
        super.disConnect();
        setConsuming(false);
    }

    public void processAndPublishMessage(final String message,
//                                         final HandleConfirmListener handleRetryListener,
                                         final Long nextPublishSeqNo) {
        if (!isConnected()) {
            LOGGER.error("No connection on broker");
        }
        String bindingKey = DISPATCH_QUEUE;
        if (DISPATCH_QUEUE.equals(getConsumingQueueName())) {
            final long mid = Long.valueOf(TG7MessageUtils.decodeMobileId(message));
            bindingKey = String.valueOf(mid);
        }
        try {
            sendMessage(message, bindingKey,
//                    handleRetryListener,
                    nextPublishSeqNo);
        } catch (IOException e) {
            LOGGER.error("[" + getBrokerHostName() + ":" + bindingKey + "] Message not sent", e);
        }
    }

    private void sendMessage(final String message, final String bindingKey,
//                               final HandleConfirmListener handleRetryListener,
                             Long nextPublishSeqNo) throws IOException {
        if (nextPublishSeqNo == NO_SEQUENCE) {
            nextPublishSeqNo = getNextPublishSeqNo();
        }
        getChannel().basicPublish(DEFAULT_EXCHANGE, bindingKey, builder.build(), SerializationUtils.serialize(message));
//        if (handleRetryListener != null) {
//            handleRetyListeners.put(nextPublishSeqNo, handleRetryListener);
//        }
        mapLatence.put(nextPublishSeqNo, System.currentTimeMillis());
    }

    public long getNextPublishSeqNo() {
        builder.messageId(String.valueOf(RandomUtils.nextLong(0, Long.MAX_VALUE)));
        return getChannel().getNextPublishSeqNo();
    }

    private void startConsuming(final String queueName, final Integer xMessagesTTL) {
        try {
            if (!isConsuming()) {
                createAndBindConsumerQueue(queueName, xMessagesTTL);
                LOGGER.info("try to consume data from queue [" + queueName + "]...");
                channel.basicConsume(queueName, IS_AUTO_ACK, CONSUMER_TAG, this);
                LOGGER.info("consuming on queue [" + queueName + "] started...");
                setConsuming(true);
            } else {
                LOGGER.warn("Consomming on queue [" + queueName + "] is already actif ");
            }
        } catch (Exception e) {
            LOGGER.error("Failed to consume on queue " + queueName, e);
        }
    }

    private void createAndBindConsumerQueue(final String queueName, final Integer xMessagesTTL) {
        try {
            channel.exchangeDeclare(DEFAULT_EXCHANGE, EXCHANGE_TYPE, IS_EXCHANGE_DURABLE);
            channel.exchangeDeclare(DLX, EXCHANGE_TYPE, IS_EXCHANGE_DURABLE);
            final Map<String, Object> args = new HashMap<>();
            if (DISPATCH_QUEUE.equals(queueName)) {
                args.put(X_MAX_LENGTH, DISPATCH_QUEUE_MAX_LENGTH);
            } else {
                args.put(X_MESSAGE_TTL, xMessagesTTL);
                args.put(DLX_ARG, DLX);
                args.put(X_DEAD_LETTER_ROUTING_KEY, DEAD_LETTER_ROUTING_KEY);
            }
            declaredQueue = channel.queueDeclare(queueName, IS_QUEUE_DURABLE, IS_EXCLUSIVE, IS_AUTO_DELETE, args);
            channel.queueBind(declaredQueue.getQueue(), DEFAULT_EXCHANGE, declaredQueue.getQueue());
            if (DISPATCH_QUEUE.equals(queueName)) {
                channel.queueBind(declaredQueue.getQueue(), DLX, DEAD_LETTER_ROUTING_KEY);
            }
        } catch (IOException e) {
            LOGGER.error("[" + getBrokerHostName() + ":" + queueName + "] failed to bind ", e);
        }
    }

    private void removeQueue(final String queueName) {
        try {
            final AMQP.Queue.UnbindOk unbindOk = channel.queueUnbind(queueName, DEFAULT_EXCHANGE, queueName);
            if (unbindOk != null) {
                LOGGER.info("Queue [" + queueName + "] Unbinded OK");
            } else {
                LOGGER.info("Queue [" + queueName + "] Unbinded NOK");
            }
            final AMQP.Queue.DeleteOk delOk = channel.queueDelete(queueName, false, false);
            if (delOk != null) {
                LOGGER.info("Queue [" + queueName + "] Deleted OK");
            } else {
                LOGGER.info("Queue [" + queueName + "] Deleted NOK");
            }
        } catch (IOException e) {
            LOGGER.error("failed to unbind/delete Queue [" + queueName + "]");
        }
    }

    public void startConsumingOnQueue(final Integer xMessagesTTL) {
        LOGGER.info("adding consumer on " + getConsumingQueueName() + " queue");
        if (isConnected()) {
            final String queueName = getConsumingQueueName();
            startConsuming(queueName, xMessagesTTL);
        } else {
            LOGGER.info("Amqp client is not connected. cannot consume on  " + getConsumingQueueName() + " queue");
        }
    }

    public void stopConsumingOnQueue() {
        if (!isConnected()) {
            LOGGER.warn("No connection found to broker ");
            return;
        }
        final String queueName = CONSUMER_TAG;//getConsumingQueueName();
        try {
            if (isConsuming()) {
                LOGGER.info("Stopping data consuming from queue [" + queueName + "]...");
                channel.basicCancel(queueName);
                LOGGER.info("Consuming from queue [" + queueName + "] stop successfully ");
                setConsuming(false);
            } else {
                LOGGER.warn("no consumer from queue [" + queueName + "] active");
            }
        } catch (IOException e) {
            LOGGER.error("Failed to stop cosuming data from queue " + queueName, e);
        }
    }

    private void notifyDataReceive(final Envelope envelope, final AMQP.BasicProperties properties, final byte[] message, final String bus) {
        LOGGER.debug("data received");
//        for (final MQClientListener listener : consumerListeners) {
//            try {
                final Object deserialized = SerializationUtils.deserialize(message);
                listener.doConsumeData(envelope, properties, deserialized);
//            } catch (SerializationException | IllegalArgumentException e) {
//                LOGGER.warn("Failed to deserialise message ", e);
//            }
//        }
    }

    public boolean isConsuming() {
        return consuming;
    }

    private void setConsuming(final boolean consuming) {
        this.consuming = consuming;
    }

    private String getConsumingQueueName() {
        return consumingQueueName;
    }

    private void connect(final String queueName, final String login, final String password) {
        consumingQueueName = queueName;
        final boolean isResponseOk = connect(login, password);
        if (isResponseOk) {
            consuming = false;
            removeQueue(queueName);
            LOGGER.info("Retour de la connexion: reinitialisation de la queue [" + queueName + "]");
        }
    }

}
