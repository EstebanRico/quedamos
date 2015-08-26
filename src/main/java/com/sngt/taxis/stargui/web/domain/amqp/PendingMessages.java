package com.sngt.taxis.stargui.web.domain.amqp;

import java.util.concurrent.*;

public class PendingMessages
{
    private boolean isConnecting;
    private final CopyOnWriteArrayList<Message> messages;
    
    public PendingMessages() {
        this.messages = new CopyOnWriteArrayList<Message>();
    }
    
    public boolean isConnecting() {
        return this.isConnecting;
    }
    
    public void setConnecting(final boolean isConnecting) {
        this.isConnecting = isConnecting;
    }
    
    public CopyOnWriteArrayList<Message> getMessages() {
        return this.messages;
    }
}
