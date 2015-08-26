package com.sngt.taxis.stargui.web.domain.messages;

public class OfferEncherEntity extends OfferDispEntity
{
    private static final long serialVersionUID = 1L;
    
    public OfferEncherEntity() {
        super(MQMessageType.OFFER_ENCHER.getType());
    }
}
