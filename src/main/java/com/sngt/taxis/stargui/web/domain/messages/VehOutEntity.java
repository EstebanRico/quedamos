package com.sngt.taxis.stargui.web.domain.messages;

public class VehOutEntity extends AbstractEntityWithCommonPart
{
    public VehOutEntity() {
        super(MQMessageType.VEH_OUT.getType());
    }
    
    public VehOutEntity(final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.VEH_OUT.getType(), geolocation, taximeterState, time);
    }
    
    public void initEg() {
    }
    
    public String toString() {
        return " [" + this.getLocation().toString() + ", Taximeter=" + this.getTaximeterState() + "]";
    }
}
