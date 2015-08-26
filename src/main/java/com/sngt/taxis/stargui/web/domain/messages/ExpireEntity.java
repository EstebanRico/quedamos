package com.sngt.taxis.stargui.web.domain.messages;

public class ExpireEntity extends AbstractEntity
{
    private static final long serialVersionUID = -2542696352387629781L;
    
    public ExpireEntity() {
        super(MQMessageType.EXPIRE.getType());
    }
    
    public void initEg() {
    }
    
    public String toString() {
        return "[]";
    }
}
