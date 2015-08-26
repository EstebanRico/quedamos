package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class RefusEntity extends AbstractEntity
{
    @Documentation("Code d'erreur")
    @JsonProperty("ec")
    private Integer mErrorCode;
    
    public RefusEntity() {
        super(MQMessageType.REFUS.getType());
    }
    
    public void initEg() {
    }
    
    public Integer getErrorCode() {
        return this.mErrorCode;
    }
    
    public void setErrorCode(final Integer errorCode) {
        this.mErrorCode = errorCode;
    }
    
    public String toString() {
        return "[mErrorCode=" + this.mErrorCode + "]";
    }
}
