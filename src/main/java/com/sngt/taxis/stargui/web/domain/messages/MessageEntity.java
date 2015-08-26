package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class MessageEntity extends AbstractEntityWithCommonPart
{
    private static final long serialVersionUID = 21089146090312970L;
    @JsonProperty("n")
    @Documentation("Num\u00e9ro du message")
    private Integer mMessage;
    
    public MessageEntity() {
        super(MQMessageType.MESSAGE.getType());
    }
    
    public MessageEntity(final Geolocation geolocation, final char taximeterState, final Integer time, final Integer messageNumber) {
        super(MQMessageType.MESSAGE.getType(), geolocation, taximeterState, time);
        this.mMessage = messageNumber;
    }
    
    public Integer getMessage() {
        return this.mMessage;
    }
    
    public void setMessage(final Integer message) {
        this.mMessage = message;
    }
    
    public void initEg() {
        super.initEg();
        this.mMessage = 3;
    }
    
    public String toString() {
        return " [mMessage=" + this.mMessage + "]";
    }
}
