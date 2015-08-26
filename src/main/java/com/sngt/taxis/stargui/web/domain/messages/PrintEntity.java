package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class PrintEntity extends AbstractEntity
{
    @Documentation("Impression Logo")
    @JsonProperty("lo")
    private boolean mLogo;
    @Documentation("Texte")
    @JsonProperty("t")
    private String mText;
    
    public PrintEntity() {
        super(MQMessageType.PRINT.getType());
    }
    
    public PrintEntity(final boolean logo, final String text, final Integer minutes) {
        super(MQMessageType.PRINT.getType());
        this.mLogo = logo;
        this.mText = text;
    }
    
    public boolean isLogo() {
        return this.mLogo;
    }
    
    public void setLogo(final boolean logo) {
        this.mLogo = logo;
    }
    
    public String getText() {
        return this.mText;
    }
    
    public void setText(final String text) {
        this.mText = text;
    }
    
    public void initEg() {
        this.mLogo = false;
        this.mText = "Vous avez \n bien le droit \n de circuler ici.";
    }
    
    public String toString() {
        return "[mLogo=" + this.mLogo + ", mText=" + this.mText + "]";
    }
}
