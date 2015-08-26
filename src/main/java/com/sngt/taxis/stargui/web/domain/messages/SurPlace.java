package com.sngt.taxis.stargui.web.domain.messages;

public class SurPlace extends AbstractEntityWithCommonPart
{
    private static final long serialVersionUID = 8263154920831728287L;
    
    public SurPlace() {
        super(MQMessageType.SUR_PLACE.getType());
    }
    
    public SurPlace(final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.SUR_PLACE.getType(), geolocation, taximeterState, time);
    }
    
    public String toString() {
        return " [" + this.getLocation() + ", getTaximeterState()=" + this.getTaximeterState() + ", getTime()=" + this.getTime() + "]";
    }
}
