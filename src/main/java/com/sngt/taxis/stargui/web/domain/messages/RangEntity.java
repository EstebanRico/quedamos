package com.sngt.taxis.stargui.web.domain.messages;

public class RangEntity extends AbstractEntityWithCommonPart
{
    private static final long serialVersionUID = 1969832175999921411L;
    
    public RangEntity() {
        super(MQMessageType.RANG.getType());
    }
    
    public RangEntity(final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.RANG.getType(), geolocation, taximeterState, time);
    }
    
    public String toString() {
        return "[" + this.getLocation() + "]";
    }
}
