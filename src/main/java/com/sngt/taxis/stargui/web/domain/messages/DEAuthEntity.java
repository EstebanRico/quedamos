package com.sngt.taxis.stargui.web.domain.messages;

public class DEAuthEntity extends AbstractEntity
{
    private static final long serialVersionUID = -2420425056411110126L;
    
    public DEAuthEntity() {
        super(MQMessageType.DEAUTH.getType());
    }
    
    public void initEg() {
    }
    
    public String toString() {
        return "[]";
    }
}
