package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class InfoChauffeurEntity extends AbstractEntity
{
    private static final long serialVersionUID = 4472888049912919666L;
    @Documentation("Panel")
    @JsonProperty("p")
    private char mPanel;
    @Documentation("Texte")
    @JsonProperty("m")
    private String mMessage;
    
    public InfoChauffeurEntity() {
        super(MQMessageType.INFO_CHAUFFEUR.getType());
        this.mPanel = 'I';
    }
    
    public char getPanel() {
        return this.mPanel;
    }
    
    public void setPanel(final char panel) {
        this.mPanel = panel;
    }
    
    public String getMessage() {
        return this.mMessage;
    }
    
    public void setMessage(final String message) {
        this.mMessage = message;
    }
    
    public void initEg() {
        this.mMessage = "Un message";
    }
    
    public String toString() {
        return " [mPanel=" + this.mPanel + ", mMessage=" + this.mMessage + "]";
    }
}
