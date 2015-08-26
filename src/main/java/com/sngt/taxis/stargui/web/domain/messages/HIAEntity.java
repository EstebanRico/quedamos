package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class HIAEntity extends AbstractEntityWithCommonPart
{
    @Documentation(value = "Etat", comment = "S = d\u00e9marrage STAR2015 ; C = connexion r\u00e9seau ; D = d\u00e9connexion r\u00e9seau")
    @JsonProperty("st")
    private String mState;
    @Documentation("Op\u00e9rateur")
    @JsonProperty("op")
    private long mOperator;
    
    public HIAEntity() {
        super(MQMessageType.HIA.getType());
    }
    
    public HIAEntity(final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.HIA.getType(), geolocation, taximeterState, time);
    }
    
    public String getState() {
        return this.mState;
    }
    
    public void setState(final String state) {
        this.mState = state;
    }
    
    public long getOperator() {
        return this.mOperator;
    }
    
    public void setOperator(final long operator) {
        this.mOperator = operator;
    }
    
    public void initEg() {
        super.initEg();
        this.mState = "S";
        this.mOperator = 123456L;
    }
    
    public String toString() {
        return "[" + super.toString() + "[mState=" + this.mState + ", mOperator=" + this.mOperator + "]]";
    }
}
