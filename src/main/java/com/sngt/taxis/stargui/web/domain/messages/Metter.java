package com.sngt.taxis.stargui.web.domain.messages;

public class Metter extends AbstractEntityWithCommonPart
{
    private static final long serialVersionUID = -9219313404776204280L;
    
    public Metter() {
        super(MQMessageType.METTER.getType());
    }
    
    public Metter(final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.METTER.getType(), geolocation, taximeterState, time);
    }
    
    public void initEg() {
        super.initEg();
    }
    
    public String toString() {
        return super.toString();
    }
}
