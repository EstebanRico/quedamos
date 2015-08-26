package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class AckCentralEntity extends AbstractEntity
{
    private static final long serialVersionUID = 1L;
    @Documentation("Type de message accus\u00e9")
    @JsonProperty("mt")
    private String msgType;
    @Documentation("N° de course ou N° de facture")
    @JsonProperty("id")
    private long identifiant;
    @Documentation("R\u00e9sultat de traitement")
    @JsonProperty("res")
    private String result;
    
    public void initEg() {
        this.identifiant = 123554L;
        this.result = "OK";
        this.msgType = "VEH_OUT";
    }
    
    public AckCentralEntity() {
        super(MQMessageType.ACK_CENTRAL.getType());
    }
    
    public String getMsgeType() {
        return this.msgType;
    }
    
    public void setMsgType(final String messageType) {
        this.msgType = messageType;
    }
    
    public long getIdentifiant() {
        return this.identifiant;
    }
    
    public void setIdentifiant(final long identifiant) {
        this.identifiant = identifiant;
    }
    
    public String getResult() {
        return this.result;
    }
    
    public void setResult(final String result) {
        this.result = result;
    }
    
    public String toString() {
        return "[msgType=" + this.msgType + ", identifiant=" + this.identifiant + ", result=" + this.result + "]";
    }
}
