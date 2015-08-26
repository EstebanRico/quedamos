package com.sngt.taxis.stargui.web.domain.messages;

public class EnchereAcceptEntity extends AbstractEntityWithCommonPart
{
    private static final long serialVersionUID = 1L;
    
    public EnchereAcceptEntity() {
        super(MQMessageType.ENCHERE_ACCEPT.getType());
    }
    
    public EnchereAcceptEntity(final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.ENCHERE_ACCEPT.getType(), geolocation, taximeterState, time);
    }
    
    public String toString() {
        return super.toString();
    }
}
