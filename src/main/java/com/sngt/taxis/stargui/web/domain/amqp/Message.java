package com.sngt.taxis.stargui.web.domain.amqp;

import java.io.*;

public class Message implements Serializable
{
    private static final long serialVersionUID = 1L;
    private long timeMillis;
    private String mgs;
    
    public Message(final long timeMillis, final String message) {
        this.timeMillis = timeMillis;
        this.mgs = message;
    }
    
    public long getTimeMillis() {
        return this.timeMillis;
    }
    
    public void setTimeMillis(final long timeMillis) {
        this.timeMillis = timeMillis;
    }
    
    public String getMgs() {
        return this.mgs;
    }
    
    public void setMgs(final String mgs) {
        this.mgs = mgs;
    }
    
    @Override
    public String toString() {
        return "Message [timeMillis=" + this.timeMillis + ", mgs=" + this.mgs + "]";
    }
}
