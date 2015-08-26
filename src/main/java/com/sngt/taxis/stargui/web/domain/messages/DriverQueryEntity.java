package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class DriverQueryEntity extends AbstractEntityWithCommonPart
{
    @Documentation("Num demande")
    @JsonProperty("akn")
    private int mAskingNumber;
    
    public DriverQueryEntity(final String messageType, final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.DRIVER_QUERY.getType(), geolocation, taximeterState, time);
    }
    
    public DriverQueryEntity() {
        super(MQMessageType.DRIVER_QUERY.getType());
    }
    
    public int getAskingNumber() {
        return this.mAskingNumber;
    }
    
    public void setAskingNumber(final int askingNumber) {
        this.mAskingNumber = askingNumber;
    }
    
    public String toString() {
        return " [mAskingNumber=" + this.mAskingNumber + "]";
    }
}
