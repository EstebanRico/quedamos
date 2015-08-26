package com.sngt.taxis.stargui.web.domain.ui;

/**
 * Created by yvu on 25/08/2015.
 */
public class AckWSMessage {

    private String channel;

    private long type;


    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AckWSMessage{" +
                "channel='" + channel + '\'' +
                ", type=" + type +
                '}';
    }
}
