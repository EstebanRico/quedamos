package com.sngt.taxis.stargui.web.domain.amqp;

import com.sngt.taxis.stargui.web.domain.messages.AbstractEntityPart;
import com.sngt.taxis.stargui.web.domain.messages.MQMessageType;

import java.io.Serializable;

public class TG7Message implements Serializable
{
    private static final long serialVersionUID = 1538899925041544137L;
    private Header header;
    private String payload;
    private MQMessageType msgType;
    private AbstractEntityPart entity;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public MQMessageType getMsgType() {
        return msgType;
    }

    public void setMsgType(MQMessageType msgType) {
        this.msgType = msgType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public AbstractEntityPart getEntity() {
        return entity;
    }

    public void setEntity(AbstractEntityPart entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "TG7Message{" +
                "header=" + header +
                ", payload='" + payload + '\'' +
                ", msgType=" + msgType +
                '}';
    }
}
