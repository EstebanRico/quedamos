package com.sngt.taxis.stargui.web.domain.messages;

public class ClientABordEntity extends AbstractEntityWithCommonPart
{
    private static final long serialVersionUID = 1L;
    
    public ClientABordEntity() {
        super(MQMessageType.CLIENT_A_BORD.getType());
    }
    
    public ClientABordEntity(final String messageType, final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(messageType, geolocation, taximeterState, time);
    }
    
    public void initEg() {
        super.initEg();
    }
    
    public String toString() {
        return "[GeoLocation=" + this.getLocation() + ", getTaximeterState()=" + this.getTaximeterState() + ", getTime()=" + this.getTime() + "]";
    }
}
