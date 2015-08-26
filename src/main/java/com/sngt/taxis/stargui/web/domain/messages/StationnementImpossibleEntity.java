package com.sngt.taxis.stargui.web.domain.messages;

public class StationnementImpossibleEntity extends AbstractEntityWithCommonPart
{
    public StationnementImpossibleEntity() {
        super(MQMessageType.STATIONNEMENT_IMPOSSIBLE.getType());
    }
    
    public StationnementImpossibleEntity(final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.STATIONNEMENT_IMPOSSIBLE.getType(), geolocation, taximeterState, time);
    }
}
