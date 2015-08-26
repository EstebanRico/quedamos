package com.sngt.taxis.stargui.web.domain.messages;

public class PauseEntity extends AbstractEntityWithCommonPart
{
    private static final long serialVersionUID = -7578299663094211296L;
    
    public PauseEntity() {
        super(MQMessageType.PAUSE.getType());
    }
    
    public PauseEntity(final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.PAUSE.getType(), geolocation, taximeterState, time);
    }
}
