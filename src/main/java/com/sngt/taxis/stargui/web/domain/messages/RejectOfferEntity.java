package com.sngt.taxis.stargui.web.domain.messages;

public class RejectOfferEntity extends AbstractEntityWithCommonPart
{
    private static final long serialVersionUID = -7715801775439177380L;
    
    public RejectOfferEntity() {
        super(MQMessageType.REJECT_OFFER.getType());
    }
    
    public RejectOfferEntity(final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.REJECT_OFFER.getType(), geolocation, taximeterState, time);
    }
}
