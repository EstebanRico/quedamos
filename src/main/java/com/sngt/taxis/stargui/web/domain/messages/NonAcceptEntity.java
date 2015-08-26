package com.sngt.taxis.stargui.web.domain.messages;

public class NonAcceptEntity extends AbstractEntityWithCommonPart
{
    private static final long serialVersionUID = -483631632656334234L;
    
    public NonAcceptEntity() {
        super(MQMessageType.NO_ACCEPT.getType());
    }
    
    public NonAcceptEntity(final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.NO_ACCEPT.getType(), geolocation, taximeterState, time);
    }
}
