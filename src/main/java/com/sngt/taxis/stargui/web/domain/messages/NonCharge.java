package com.sngt.taxis.stargui.web.domain.messages;

public class NonCharge extends AbstractEntityWithCommonPart
{
    private static final long serialVersionUID = 343323336506212901L;
    
    public NonCharge() {
        super(MQMessageType.NON_CHARGE.getType());
    }
    
    public void initEg() {
    }
    
    public String toString() {
        return "NonCharge [Location=" + this.getLocation() + ", TaximeterState=" + this.getTaximeterState() + ", Time=" + this.getTime() + ", Mid=" + this.getMid() + "]";
    }
}
