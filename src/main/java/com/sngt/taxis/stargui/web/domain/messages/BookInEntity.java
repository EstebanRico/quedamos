package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class BookInEntity extends AbstractEntityWithCommonPart
{
    @Documentation("Zone")
    @JsonProperty("an")
    private Integer mZoneNumber;
    
    public BookInEntity() {
        super(MQMessageType.BOOK_IN.getType());
    }
    
    public BookInEntity(final Geolocation geolocation, final Integer time, final char taximeterState, final Integer zoneNumber) {
        super(MQMessageType.BOOK_IN.getType(), geolocation, taximeterState, time);
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
        return "[" + this.getLocation() + "mZoneNumber=" + this.mZoneNumber + "]";
    }
}
