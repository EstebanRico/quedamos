package com.sngt.taxis.stargui.web.domain.messages;

public class BasculeEntity extends AbstractEntityWithCommonPart
{
    private static final long serialVersionUID = -3875363093084866938L;
    
    public BasculeEntity() {
        super(MQMessageType.BASCULE.getType());
    }
    
    public BasculeEntity(final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.BASCULE.getType(), geolocation, taximeterState, time);
    }
}
