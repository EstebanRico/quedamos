package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class ChronometerEntity extends AbstractEntity
{
    private static final long serialVersionUID = 129269973213700545L;
    @Documentation("Message")
    @JsonProperty("m")
    private String mMessage;
    @Documentation("Minutes au d\u00e9part du chrono")
    @JsonProperty("d")
    private Integer mMinutes;
    
    public ChronometerEntity() {
        super(MQMessageType.CHRONOMETER.getType());
    }
    
    public ChronometerEntity(final String message, final Integer minutes) {
        super(MQMessageType.CHRONOMETER.getType());
        this.mMessage = message;
        this.mMinutes = minutes;
    }
    
    public String getMessage() {
        return this.mMessage;
    }
    
    public void setMessage(final String message) {
        this.mMessage = message;
    }
    
    public Integer getMinutes() {
        return this.mMinutes;
    }
    
    public void setMinutes(final Integer minutes) {
        this.mMinutes = minutes;
    }
    
    public void initEg() {
        this.mMessage = "Il vous reste seuelement";
        this.mMinutes = 5;
    }
    
    public String toString() {
        return " [mMessage=" + this.mMessage + ", mMinutes=" + this.mMinutes + "]";
    }
}
