package com.sngt.taxis.stargui.web.domain.messages;

public class GPSUpdateEntity extends AbstractEntityWithCommonPart
{
    private static final long serialVersionUID = 7428312833311620810L;
    
    public GPSUpdateEntity() {
        super(MQMessageType.GPS_UPDATE.getType());
    }
    
    public GPSUpdateEntity(final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.GPS_UPDATE.getType(), geolocation, taximeterState, time);
    }
    
    public String toString() {
        return " [" + this.getLocation() + "]";
    }
}
