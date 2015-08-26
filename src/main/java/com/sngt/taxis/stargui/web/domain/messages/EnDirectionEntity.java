package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class EnDirectionEntity extends AbstractEntityWithCommonPart
{
    @Documentation("Num\u00e9ro de zone")
    @JsonProperty("an")
    private Integer mZoneNumber;
    
    public EnDirectionEntity() {
        super(MQMessageType.ENDIRECTION.getType());
    }
    
    public EnDirectionEntity(final Geolocation geolocation, final Integer time, final char taximeterState, final Integer zoneNumber) {
        super(MQMessageType.ENDIRECTION.getType(), geolocation, taximeterState, time);
        this.mZoneNumber = zoneNumber;
    }
    
    public Integer getZoneNumber() {
        return this.mZoneNumber;
    }
    
    public void setZoneNumber(final Integer zoneNumber) {
        this.mZoneNumber = zoneNumber;
    }
    
    public void initEg() {
        super.initEg();
        this.mZoneNumber = 23;
    }
    
    public String toString() {
        return "[" + this.getLocation() + ",mZoneNumber=" + this.mZoneNumber + "]";
    }
}
