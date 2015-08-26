package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class ACKEntity extends AbstractEntityWithCommonPart
{
    private static final long serialVersionUID = -1297466221079716310L;
    @Documentation("Type du message")
    @JsonProperty("mt")
    private Long mACKMessageType;
    
    public ACKEntity() {
        super(MQMessageType.ACK.getType());
    }
    
    public ACKEntity(final Long ackMessageType, final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.ACK.getType(), geolocation, taximeterState, time);
        this.mACKMessageType = ackMessageType;
    }
    
    public void setACKMessageType(final Long ackMessageType) {
        this.mACKMessageType = ackMessageType;
    }
    
    public Long getACKMessageType() {
        return this.mACKMessageType;
    }
    
    public void initEg() {
        super.initEg();
        this.mACKMessageType = 2L;
    }
    
    public String toString() {
        return "[" + this.getLocation() + "]";
    }
}
