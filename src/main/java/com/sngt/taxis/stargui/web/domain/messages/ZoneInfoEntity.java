package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class ZoneInfoEntity extends AbstractEntityWithCommonPart
{
    private static final long serialVersionUID = -3340807384999373302L;
    @Documentation("Zone")
    @JsonProperty("an")
    private Integer mZoneNumber;
    
    public ZoneInfoEntity() {
        super(MQMessageType.ZONE_INFO.getType());
    }
    
    public ZoneInfoEntity(final Geolocation geolocation, final char taximeterState, final Integer time, final Integer zoneNumber) {
        super(MQMessageType.ZONE_INFO.getType(), geolocation, taximeterState, time);
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
        this.mZoneNumber = 12;
    }
    
    public String toString() {
        return " [mZoneNumber=" + this.mZoneNumber + "," + this.getLocation() + "]";
    }
}
