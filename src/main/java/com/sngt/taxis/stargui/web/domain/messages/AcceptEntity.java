package com.sngt.taxis.stargui.web.domain.messages;

public class AcceptEntity extends AbstractEntityWithCommonPart
{
    private static final long serialVersionUID = -7115079682962932485L;
    
    public AcceptEntity() {
        super(MQMessageType.ACCEPT.getType());
    }
    
    public AcceptEntity(final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.ACCEPT.getType(), geolocation, taximeterState, time);
    }
    
    public String toString() {
        return "[ " + this.getLocation() + "]";
    }
}
