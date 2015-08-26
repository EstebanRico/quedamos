package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class RedispatchEntity extends AbstractEntity
{
    @Documentation("Identifiant de course")
    @JsonProperty("fi")
    private Integer mFareId;
    
    public RedispatchEntity() {
        super(MQMessageType.REDISPATCH.getType());
    }
    
    public void initEg() {
        this.mFareId = 2;
    }
    
    public Integer getFareId() {
        return this.mFareId;
    }
    
    public void setFareId(final Integer fareId) {
        this.mFareId = fareId;
    }
    
    public String toString() {
        return " [Numero de course =" + this.mFareId + "]";
    }
}
