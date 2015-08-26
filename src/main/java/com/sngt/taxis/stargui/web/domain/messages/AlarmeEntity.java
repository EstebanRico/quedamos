package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class AlarmeEntity extends AbstractEntityWithCommonPart
{
    @Documentation("Zone")
    @JsonProperty("an")
    private Integer mAreaNumber;
    
    public AlarmeEntity() {
        super(MQMessageType.ALARME.getType());
    }
    
    public AlarmeEntity(final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.ALARME.getType(), geolocation, taximeterState, time);
    }
    
    public Integer getAreaNumber() {
        return this.mAreaNumber;
    }
    
    public void setAreaNumber(final Integer areaNumber) {
        this.mAreaNumber = areaNumber;
    }
    
    public String toString() {
        return " [mAreaNumber=" + this.mAreaNumber + "]";
    }
    
    public void initEg() {
        super.initEg();
        this.mAreaNumber = 641;
    }
}
