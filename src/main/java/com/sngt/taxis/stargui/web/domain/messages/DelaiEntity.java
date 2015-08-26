package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class DelaiEntity extends AbstractEntityWithCommonPart
{
    private static final long serialVersionUID = 2559749543320124340L;
    @Documentation("D\u00e9lai d'approche")
    @JsonProperty("tg")
    private Integer mTimeToGo;
    
    public DelaiEntity() {
        super(MQMessageType.DELAI.getType());
    }
    
    public DelaiEntity(final Geolocation geolocation, final char taximeterState, final Integer time, final Integer timeToGo) {
        super(MQMessageType.DELAI.getType(), geolocation, taximeterState, time);
        this.mTimeToGo = timeToGo;
    }
    
    public Integer getTimeToGo() {
        return this.mTimeToGo;
    }
    
    public void setTimeToGo(final Integer timeToGo) {
        this.mTimeToGo = timeToGo;
    }
    
    public void initEg() {
        super.initEg();
        this.mTimeToGo = 12;
    }
    
    public String toString() {
        return " [mTimeToGo=" + this.mTimeToGo + this.getLocation().toString() + "]";
    }
}
