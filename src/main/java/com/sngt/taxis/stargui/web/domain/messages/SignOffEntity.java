package com.sngt.taxis.stargui.web.domain.messages;

public class SignOffEntity extends AbstractEntityWithCommonPart
{
    private static final long serialVersionUID = -3435868370205738378L;
    
    public SignOffEntity() {
        super(MQMessageType.SIGN_OFF.getType());
    }
    
    public SignOffEntity(final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.SIGN_OFF.getType(), geolocation, taximeterState, time);
    }
    
    public String toString() {
        return "[" + this.getLocation() + ", TaximeterState()=" + this.getTaximeterState() + ", Time()=" + this.getTime() + "]";
    }
}
