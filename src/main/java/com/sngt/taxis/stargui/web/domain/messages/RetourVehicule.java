package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class RetourVehicule extends AbstractEntityWithCommonPart
{
    private static final long serialVersionUID = 3724048114727561959L;
    @Documentation("Flag Auto")
    @JsonProperty("fa")
    private boolean mFlagAuto;
    
    public RetourVehicule() {
        super(MQMessageType.VEH_IN.getType());
    }
    
    public RetourVehicule(final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.VEH_IN.getType(), geolocation, taximeterState, time);
    }
    
    public String toString() {
        return " [" + this.getLocation().toString() + ", Taximeter=" + this.getTaximeterState() + ",mFlagAuto" + this.mFlagAuto + "]";
    }
}
