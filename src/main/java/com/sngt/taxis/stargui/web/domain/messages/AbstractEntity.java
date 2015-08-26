package com.sngt.taxis.stargui.web.domain.messages;

import java.io.*;
import com.fasterxml.jackson.annotation.*;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractEntity extends AbstractEntityPart implements Serializable
{
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    private String mMessageType;
    @JsonIgnore
    private int mMid;
    
    public int getMid() {
        return this.mMid;
    }
    
    public void setMid(final int mMid) {
        this.mMid = mMid;
    }
    
    public AbstractEntity(final String messageType) {
        this.mMessageType = messageType;
    }
    
    public String getMessageType() {
        return this.mMessageType;
    }
}
