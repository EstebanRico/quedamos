package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class PromptDispEntity extends AbstractEntity
{
    private static final long serialVersionUID = 3979246588276531450L;
    @JsonProperty("m")
    private String message;
    
    public PromptDispEntity() {
        super(MQMessageType.PROMPT_DISP.getType());
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public String toString() {
        return " [message=" + this.message + "]";
    }
    
    public void initEg() {
    }
}
