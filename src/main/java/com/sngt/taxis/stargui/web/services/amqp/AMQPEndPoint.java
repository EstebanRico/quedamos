package com.sngt.taxis.stargui.web.services.amqp;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class AMQPEndPoint {
    protected AMQP.BasicProperties.Builder builder;
    public static final String JKS = "JKS";
    public static final String PKCS12 = "PKCS12";
    public static final String X509 = "SunX509";
    public static final String SSL_VERSION = "SSLv3";
    public static final int RECOVERY_INTERVAL = 2000;
    public static final int TIME_OUT = 5000;
    private static final int RECONNECTION_HEARTBEAT = 5;
    private String brokerHostName;
    private String brokerHostPort;
    private Connection connection;
    protected final ConcurrentMap<Long, Long> mapLatence;
//    protected final ConcurrentMap<Long, HandleConfirmListener> handleRetyListeners;
    protected Channel channel;
    private static final Logger LOGGER = LoggerFactory.getLogger(AMQPClient.class);
    private ConnectionFactory factory;
    private final ReadWriteLock lock;
    protected final Lock readLock;
    protected final Lock writeLock;

    public AMQPEndPoint(final String brokerHostName, final String brokerHostPort, final boolean isUseSSL, final boolean autoReconnect) {
        mapLatence = new ConcurrentHashMap<>();
        lock = new ReentrantReadWriteLock();
        readLock = lock.readLock();
        writeLock = lock.writeLock();
        LOGGER.info("Endpoint [" + brokerHostName + " - " + brokerHostPort + "]");
        builder = new AMQP.BasicProperties().builder();
        this.brokerHostName = brokerHostName;
        this.brokerHostPort = brokerHostPort;
        if (autoReconnect) {
            factory = initFactoryForAutoReconnect(brokerHostName);
        } else {
            factory = initFactoryWithoutAutoReconnect(brokerHostName);
        }
        try {
            if (isUseSSL) {
                LOGGER.info("Using SSL on port=" + brokerHostPort);
                factory.useSslProtocol();
            }
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            LOGGER.error("Failed to init keyStore", e);
        }
    }

    protected ConnectionFactory initFactoryForAutoReconnect(final String brokerHostName) {
        final ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(brokerHostName);
        factory.setAutomaticRecoveryEnabled(true);
        factory.setConnectionTimeout(TIME_OUT);
        factory.setRequestedHeartbeat(RECONNECTION_HEARTBEAT);
        if (!StringUtils.isEmpty(brokerHostPort)) {
            factory.setPort(Integer.valueOf(brokerHostPort));
        }
        return factory;
    }

    protected ConnectionFactory initFactoryWithoutAutoReconnect(final String brokerHostName) {
        final ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(brokerHostName);
        factory.setAutomaticRecoveryEnabled(false);
        factory.setConnectionTimeout(TIME_OUT);
        factory.setRequestedHeartbeat(0);
        if (!StringUtils.isEmpty(brokerHostPort)) {
            factory.setPort(Integer.valueOf(brokerHostPort));
        }
        return factory;
    }

    public boolean connect(final String username, final String password) {
        if (!isConnected()) {
            synchronized (this) {
                if (!isConnected()) {
                    factory.setUsername(username);
                    factory.setPassword(password);
                    try {
                        connection = factory.newConnection();
                        (channel = connection.createChannel()).confirmSelect();
                        channel.addConfirmListener(getConfirmListener());
                        LOGGER.info("Broker Connected successfuly");
                        return true;
                    } catch (Exception ex) {
                        LOGGER.error("Failed to open connection on broker [" + getBrokerHostName() + "]", ex);
                    }
                }
            }
        }
        return false;
    }

    private ConfirmListener getConfirmListener() {
        return new ConfirmListener() {
            @Override
            public void handleNack(final long deliveryTag, final boolean multiple) throws IOException {
                AMQPEndPoint.LOGGER.error("[ Nack for message:[ID=" + deliveryTag + "]");
            }

            @Override
            public void handleAck(final long deliveryTag, final boolean multiple) throws IOException {
                AMQPEndPoint.LOGGER.error("[ handle ack for message:[ID=" + deliveryTag + "]");
                final long timeInMillis = (AMQPEndPoint.this.mapLatence.get(deliveryTag) != null) ? AMQPEndPoint.this.mapLatence.get(deliveryTag) : 0L;
                final long totalTimeMillis = System.currentTimeMillis() - timeInMillis;
                AMQPEndPoint.this.handlePublisherConfirm(totalTimeMillis);
                AMQPEndPoint.this.mapLatence.remove(deliveryTag);
            }
        };
    }


    public boolean isConnected() {
        return channel != null && channel.isOpen() && connection != null;
    }


    public void disConnect() {
        if (channel == null || connection == null) {
            LOGGER.warn("You are trying to disconnect broker but no connection exist");
            return;
        }
        if (!channel.isOpen() || !connection.isOpen()) {
            LOGGER.warn("Connection is already closed");
            return;
        }
        try {
            LOGGER.warn("Broker Disconnection...");
            getChannel().close();
            connection.close();
            LOGGER.warn("Broker Disconnected successfuly ");
        } catch (IOException | TimeoutException e) {
            LOGGER.error("Failed to close connection on broker [" + getBrokerHostName(), e);
        }
    }

    public String getBrokerHostName() {
        return brokerHostName;
    }

    public Connection getConnection() {
        return connection;
    }

    public Channel getChannel() {
        return channel;
    }

    protected abstract void handlePublisherConfirm(final long p0);
}
